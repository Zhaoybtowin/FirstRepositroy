package test;

/*
  继承关系中：
  同名的成员变量：建对象时等号左边用的是哪个类，变量值就是那个类的，子类中没有就往父类上找。
  同名的成员方法：建对象时等号用边用的是哪个类，方法就是那个类的，子类中没有就往父类上找。
 */
public class TestFuZi {
    public static void main(String[] args) {
        Zi obj = new Zi();
        System.out.println(obj.num); //2
        obj.method();                //Zi
        obj.sss();
        System.out.println("======================");

        Fu obk = new Zi();
        System.out.println(obk.num); //1
        obk.method();                //Zi
        obk.sss();

        Zi s = (Zi)obk;
        s.methodZi();
        System.out.println(s.num);

        int n = (int)10.5;
        System.out.println(n);
    }
}
