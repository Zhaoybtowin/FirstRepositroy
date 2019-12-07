package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestPerson1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Java/src/io/pp"));

        Object object = objectInputStream.readObject();

        objectInputStream.close();

        Person p = (Person)object;
        System.out.println(p);
    }
}
