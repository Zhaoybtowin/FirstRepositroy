package thread;

import java.util.concurrent.*;

/**
 * 使用线程池的好处：
 *
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理：
 *   corePoolSize:核心池的大小
 *   maximumPoolSize:最大线程数
 *   keepAliveTime:线程没有任务时最多保持多长时间后会终止
 *
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int  i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int  i=0;i<=100;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }
}

class callTest implements Callable{
    @Override
    public Object call() throws Exception{
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(1);

        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口
        service.execute(new NumberThread());//适合使用于Runnable
        service.execute(new NumberThread1());
        //submit方法示例
        callTest c = new callTest();
        Future future = service.submit(c);
        try {
            Object sum =future.get();
            System.out.println("sss: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("=================");
        service.submit(new NumberThread());

//      service.submit(Callable callable);//适合使用于Callable
        //关闭连接池
        service.shutdown();
    }
}
