package test;

public class TestInt {
    public static void main(String[] args) {

        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer与int比较都会自动拆箱，所以为true
        System.out.println(i == i2);
        System.out.println(i == i3);
        System.out.println(i2 == i3);//false
        System.out.println("**************");
        //java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        //下面附上源码：见下图
        //对于-128到127之间的数，会进行缓存。之外的数，它走的还是 new Integer(i)。
        Integer i5 = 1;
        Integer i6 = 1;
        System.out.println(i5 == i6);//true：因为这两个数被IntegerCache缓存，所以是相等的。
        Integer i5a = 128;
        Integer i6a = 128;
        System.out.println(i5a == i6a);//false：因为超过了缓存范围，所以新建了两个对象，结果自然不同。
        Integer ii5 = new Integer(1);
        System.out.println(i5 == ii5); //false：ii5是新建的对象，而i5是在IntegerCache缓存中，所以结果不同。
        Integer i7 = new Integer(128);
        System.out.println(i7 == i3);  //false：因为对象不一样，所以地址不一样。

    }
}
