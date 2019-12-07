package thread;


class Window4 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    public static synchronized void show(){
        //要声明成静态的
        //同步监视器  Window4.class（唯一的类，对象也是唯一的。）
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " 号窗口，票号为 " + ticket);
            ticket--;
        }
    }
}

public class WindowTes3 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("1");
        w2.setName("2");
        w3.setName("3");

        w1.start();
        w2.start();
        w3.start();

    }
}
