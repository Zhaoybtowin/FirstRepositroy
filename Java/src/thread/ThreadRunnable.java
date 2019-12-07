package thread;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 */

class ThreadRun implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        //多态的一种体现：Thread类有Thread(Runnable target)构造器，ThreadRun实现了Runnable接口，所以自然可以作为参数来创建Thread对象。
        //Thread类私有属性中有 private Runnable target
        //    public Thread(Runnable target) {
        //        init(null, target, "Thread-" + nextThreadNum(), 0);
        //    }
        //使用该构造方法生成Thread对象时，会传target进去，这个target就是threadRun，他就会替换掉Thread的私有属性target
        //当Thread对象运行其run方法时，自然就走的是threadRun定义好的run方法啦。
//        public void run() {
//            if (target != null) {
//                target.run();   此时就是覆盖后的target
//            }
//        }
        Thread thread = new Thread(threadRun);

        thread.start();
    }
}
