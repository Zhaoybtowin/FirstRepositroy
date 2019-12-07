package thread;

/**
 * 在JAVA中，我们通过同步机制，来解决线程的安全问题。
 * 方式一：同步代码块
 *
 *     synchronized(同步监视器){
 *         //需要被同步的代码
 *     }
 *
 *     说明:1.操作共享数据的代码，即为需要被同步的代码。  ---> 不能包多了，也不能包少了。
 *          2.共享数据：多个线程共同操作的变量，比如ticket
 *          3.同步监视器（锁）：任何一个类的对象，都可以充当锁。
 *            要求：多个线程必须要共用同一把锁
 *
 *          补充：在实现Runnable接口创建多线程的方式中。可以使用 this 充当同步监视器；
 *               在继承Thread类创建多线程的方式中，慎用（或不用）this 充当同步监视器，考虑使用当前类充当同步监视器。
 *
 *  方式二：同步方法
 *         如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *    总结：1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *         2.非静态的同步方法，同步监视器是：this
 *           静态的同步方法，同步监视器是：当前类本身
 *
 *
 *
 * 同步 好处：解决了线程的安全问题。
 *      局限性：操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低。
 */

class Window2 extends Thread{

    private static int ticket = 100;
    static Object obj = new Object();//充当锁的对象

    @Override
    public void run() {
        while (true){
            synchronized(obj) {
           //synchronized(Window2.class){  Class c = Window2.class; 类也是对象;
           //                              Window2.class 只能加载一次，可以作为唯一的对象。
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 号窗口，票号为 " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("1");
        w2.setName("2");
        w3.setName("3");

        w1.start();
        w2.start();
        w3.start();

    }
}
