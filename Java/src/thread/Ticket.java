package thread;

/**
 * 三个窗口共卖100张票
 */

class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() +" 号窗口，票号为 "+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class Ticket {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("1");
        w2.setName("2");
        w3.setName("3");

        w1.start();
        w2.start();
        w3.start();

    }
}
