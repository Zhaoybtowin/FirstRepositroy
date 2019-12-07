package thread;



class Window3 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            //把操作共享数据的代码抽成方法
            show();
        }
    }

    public synchronized void show(){
        //有同步监视器，默认为this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " 号窗口，票号为 " + ticket);
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.setName("1");
        w2.setName("2");
        w3.setName("3");

        w1.start();
        w2.start();
        w3.start();

    }
}
