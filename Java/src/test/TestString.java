package test;

public class TestString {
    public static void main(String[] args){
        String a = "zyb";
        String b = new String("zyb");
        String c = new String("zyb");

        System.out.println(a == b);
        System.out.println(c == b);
        System.out.println("++++++++++++++++");
        String d = new String(a);
        System.out.println(a == d);
        char[] chars = {'z','y','b'};
        String e = new String(chars);
        System.out.println(e);
        System.out.println(a == e);
        String f = new String(a);
        System.out.println(d == f);
        System.out.println("===============");
        String s = "Hello";
        s = "Java";
        String s1 = "Java";
        System.out.println(s == s1);
    }
}
