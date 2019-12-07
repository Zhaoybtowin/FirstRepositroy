package thread;

/**
 * 多线程的创建，方式一：继承Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()  --->  将此线程要执行的操作写在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()  --->  ①启动当前线程 ②调用当前线程的run()
 */

//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run()
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(this.getName()+":"+i);
            }
        }
    }
}

//例子：遍历100以内的所有的偶数
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //4.通过此对象调用start()
        myThread.setName("fen");
        myThread.start();

        //如果想再启动一个线程，不可以让已经start()的线程去执行，否则会报异常（非法线程状态）
        //需要重新创建一个线程对象才能达到目的
        MyThread thread = new MyThread();
        thread.setName("gji");
        thread.start();
        //便于理解：这部分和上面的部分是“同时”执行的，这是主线程，上是分线程，
        //         在极短的时间片中，每次运行程序的结果都是不一样的。
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
