package test;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(3);
        double b = r.nextDouble();

        double  d = Math.random();
        System.out.println(b);

        ArrayList<TestInt> t = new ArrayList<>();
        System.out.println(t);
    }
}

