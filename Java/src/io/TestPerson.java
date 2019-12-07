package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestPerson {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Java/src/io/pp"));

        objectOutputStream.writeObject(new Person("JJ",0));

        objectOutputStream.close();
    }
}
