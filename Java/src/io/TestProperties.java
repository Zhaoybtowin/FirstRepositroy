package io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//        properties.setProperty("林俊杰","帅");
//        properties.setProperty("田馥甄","美");

//        FileWriter fileWriter = new FileWriter("Java/src/io/testP");
//        properties.store(fileWriter,"test");

        FileReader fileReader = new FileReader("Java/src/io/testP");
        properties.load(fileReader);

        Set<String> s = properties.stringPropertyNames();
        for(String s1 : s){
            System.out.println(s1+"="+properties.getProperty(s1));
        }
    }
}
