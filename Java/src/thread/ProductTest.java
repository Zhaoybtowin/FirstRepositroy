package thread;

//店员
class Clerk{
    private int number = 0;

    public synchronized void product(){
            if(number < 20){
                number++ ;
                System.out.println(Thread.currentThread().getName() + "开始生产第" + number +"个产品");
                notify();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public synchronized void consume(){
            if(number > 0){

                number-- ;
                System.out.println(Thread.currentThread().getName() + "开始消费第" + number +"个产品");
                notify();

            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

//生产者
class Producter extends Thread{
    //这种题把持有共享数据的对象抽出来，将生产者消费者要做的操作在店员类中实现，两个线程的run方法直接调就好。
    private Clerk clerk;

    public Producter(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品");
        while(true) {

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.product();
        }
    }
}

//消费者
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + "开始消费产品");
        while (true){
            clerk.consume();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p = new Producter(clerk);
        Consumer c = new Consumer(clerk);

        p.setName("生产者");
        c.setName("消费者");

        p.start();
        c.start();
    }
}
