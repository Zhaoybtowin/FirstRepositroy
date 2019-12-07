package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.转换流：属于字符流（所以操作的是字节数组）
 *   InputStreamReader：将一个字节的输入流转换为字符的输出流
 *   OutputStreamWriter：将一个字节的输出流转换为字符的输入流
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 ----> 字符数组、字符串（看不懂到能让人看懂）
 *   编码：字符数组、字符串 ----> 字节、字节数组
 *
 * 4.字符集
 */
public class InputOutputReaderTest{
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        //InputStreamReader isr = new InputStreamReader(fis);//这里使用了系统的默认字符集
        //参数指明了字符集，具体使用那个字符集，取决于文件hello.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
    }
}
