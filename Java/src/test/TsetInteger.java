package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TsetInteger {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        collection.add("aaa");
        Object[] o = collection.toArray();
        System.out.println(Arrays.toString(o));

        Iterator iterator = collection.iterator();//多态
        Iterator iterator1 = new Iterator() {//匿名内部类
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };

    }
    //泛型的通配符
    public void method(ArrayList<?> list){

    }
}
