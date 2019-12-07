package FanShe;

public class TestPerson {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1 = Class.forName("FanShe.Person");
        System.out.println(cls1);//class FanShe.Person

        Class cls2 = Person.class;
        System.out.println(cls2);//class FanShe.Person

        Person p = new Person();
        Class cls3 = p.getClass();//getClass是Object类中的方法
        System.out.println(cls3);//class FanShe.Person

        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true

        String className = cls1.getName();
        System.out.println(className);
    }
}
