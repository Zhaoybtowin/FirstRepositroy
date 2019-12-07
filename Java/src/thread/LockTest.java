package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  (JDK5.0)
 *
 * 1.synchronized 与 Lock 的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步(lock())，同时结束同步也需要手动的实现(unlock())
 * 2.优先使用顺序
 *   Lock -> 同步代码块（已经进入了方法体，分配了相应资源）-> 同步方法（在方法体之外）
 *
 */
class Windowlock implements Runnable{

    private int ticket = 100;
    //1.实例化，有两个构造器
    //  public ReentrantLock(boolean fair):当fair为true时，锁是公平的，会秉持“先进先出”原则，是有序的。
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //2.调用锁定方法 lock()
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " 号窗口，票号为 " + ticket);
                    ticket--;
                }else{
                    break;
                }
            } finally {
                //3.调用解锁方法 lock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Windowlock w = new Windowlock();

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
