package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        Collections.addAll(s,"a","b","c");

        Collections.shuffle(s);
        System.out.println(s);
        Collections.sort(s);
        System.out.println(s);
    }
}
