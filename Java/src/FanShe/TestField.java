package FanShe;

import java.lang.reflect.Field;

public class TestField {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Field[] fields = personClass.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }

        Field f = personClass.getField("name");
        Person p = new Person();
        f.set(p,"zzz");

        Field f1 = personClass.getDeclaredField("sex");
        f1.setAccessible(true);
        System.out.println(f1.get(p));
    }
}
