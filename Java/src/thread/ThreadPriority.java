package thread;

/**
 * 线程的优先级：
 * 1. MAX_PRIORITY:10
 *    MIN_PRIORITY:1
 *    NORM_PRIORITY:5  --->  默认优先级
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程CPU的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下会被执行，
 *        并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(getPriority()+":"+i);
            }
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        //设置分线程的优先级
        myThread.setPriority(Thread.MAX_PRIORITY);//写数字也可
        myThread.start();

        Thread thread = new Thread();
        thread.start();
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getPriority()+":"+i);
            }
        }
    }
}