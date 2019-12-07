package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("Java\\hello.txt");
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(f,true);
            fw.write("\n");
            fw.write("加油");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fw){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            fr = new FileReader(f);
            char[] c = new char[5];
            int data;
            while((data = fr.read(c)) != -1){
                for(int  i = 0 ;i < data;i++){
                    System.out.print(c[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
