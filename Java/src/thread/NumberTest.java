package thread;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1、2交替打印
 *
 * 涉及到的三个方法：
 * 1.wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * 2.notify():一旦执行此方法，就会唤醒被wait()的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * 3.notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()、notify()、notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器，
 *   否则会出现异常，看下例中obj对象的使用。
 * 3.wait()、notify()、notifyAll()三个方法是定义在Object类中，不是Thread类
 *  （就是为了保证任何类充当监视器时都能调用这三个方法）。
 */

class Number implements Runnable{
    private int number = 1;
    //Object obj = new Object();

    @Override
    public void run() {
        while(true){

            synchronized (this) {
            //synchronized (obj) {
                notify();
                //obj.notify();
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName() + ": "+ number);
                    number++;

                    try {
                        //进入阻塞状态，释放锁，其他线程可以操作共享数据number，线程2得以执行。
                        wait();
                        //obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class NumberTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
