package thread;

/**
 * 测试Thread中的常用方法：
 * 1.start()：启动当前线程；调用当前线程的run()方法
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，返回执行当前代码的线程（Thread.currentThread可以获取到主线程，也可以用get、setName方法）
 * 4.getName()：获取当前线程的名字（Thread类有name属性）
 * 5.setName()：设置当前线程的名字
 * 6.yield()：释放当前CPU的执行权（可能再次被当前线程抢到，具体是由CPU决定的，但释放的动作确实发生了）
 * 7.join()：在线程A中调用线程B的join()，此时线程A就进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 * 8.stop()：已过时。当执行此方法时，强制结束当前进程。
 * 9.sleep(long millitime)：让当前线程“睡眠”指定的millitime毫秒，在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10.isAlive()：判断当前线程是否存活
 *
 *
 *
 *
 */

class ThreadOk extends Thread{
    public void run(){
        for(int i = 0;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }

            //因为父类run方法没有throws异常，所以只能try、catch
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//            if(i % 20 == 0){
//                this.yield();
//            }
        }
    }

    //Thread类提供命名的构造器
//    public ThreadOk(String name){
//        super(name);
//    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadOk threadOk = new ThreadOk();
        threadOk.setName("-----------分线程----------");
        threadOk.start();
        //给主线程设置名字
        Thread.currentThread().setName("-----------主线程----------");
        for(int i = 0;i < 100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//            if(i == 20){
//                try {
//                    threadOk.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(threadOk.isAlive());
    }
}
