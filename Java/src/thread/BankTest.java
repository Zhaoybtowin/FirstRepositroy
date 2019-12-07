package thread;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {
}


class Bank{
    private Bank(){}

    private static Bank bank = null;

    public static Bank getBank(){
        //解决：同步代码块/同步方法（效率不高）
        /*synchronized (Bank.class) {//或者直接在方法上加 synchronized
            if(bank == null){
                bank = new Bank();
            }
            return bank;
        }*/

        //优化：在同步外套一层判断
        //注意：前期同时进入该方法的不止一个线程，会有几个线程走同步方法，但是再后期的线程是不会走进同步方法中去的。
        if(bank == null){
            synchronized (Bank.class) {
                if(bank == null){
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
