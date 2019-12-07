package io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

    /**
     * 如果想用main方法测试的话，路径需要注意下
     */
    public static void main(String[] args){
        //这是相对于当前工程的地址
        File file = new File("hello.txt");
        //F:\Project_practice\hello.txt  ---  获得的地址是这个，但实际是不存在的
        //这样之后获取文件的话是获取不到的，所以这种写法不对，看下面这个。
        System.out.println(file.getAbsolutePath());


        File file1 = new File("Java\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 将Java下的hello.txt文件内容读入程序中，并输出到控制台。
     */
    //注：异常不要抛，要用try、catch
    //原因：创建流时，如果产生异常，光抛出来，但是流并未被关闭，这样就造成了资源的浪费。
    @Test
    public void testFileReader(){
        FileReader fileReader = null;
        try {
            //实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前Module
            //提供具体的流，节点流（建好管道了），这样程序就可以识别了。
            fileReader = new FileReader(file);
            //数据的读入
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1。
            int data = fileReader.read();
            while(data != -1){
                System.out.print((char)data);//如果不加转换，读到'a',就输出97了
                data = fileReader.read();//循环，让程序读下一个字符。
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //为了防止空指针，即fileReader实例化时异常，就不让程序关闭流（因为此时没有流）。
                if(fileReader != null){
                    //流的关闭操作！！
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1(){
        FileReader fileReader = null;
        try{
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            //读入操作
            //read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                  //错误的写法：假设文本内容为 helloworld123,那么这样输出的结果为helloworld123ld。
                  //原因：cbuf.length固定为5，hello world 123，第三组时只有三个字符，而数组读取时，
                  //     是将之前位置的值覆盖，即world前三个字符要由123覆盖，而剩下的字符ld则无法被
                  //     覆盖，所以会多出来，错误原因就是循环限制条件错了，应该是len（每次取的长度）。
//                for(int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }

                for(int i = 0;i < len;i++){
                    System.out.print(cbuf[i]);
                }
                //方式2：用String字符串来接char数组
                //这个错误的原因和上面错误的原因一样，都是没有取正确的长度造成的
//                String str = new String(cbuf);
//                System.out.print(str);

                //public String(char value[], int offset, int count)
                //String类的一个构造方法，取固定位置的数组中的数据
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     从内存中写出数据到硬盘的文件里

     说明：
     1.输出操作，对应的File可以不存在，并不会报错。
     2.File对应的硬盘中的文件是否存在：
       如果不存在，在输出的过程中，会自动创建此文件。
       如果存在，看流使用的是哪一种构造器（append:true/false<=>null）
     */
    @Test
    public void testFileWriter(){
        FileWriter fileWriter = null;
        try {
            //提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //提供FileWriter的对象，用于数据的写出
            //三种构造器，append(附加)：true--在原有的基础上继续添加值；false--覆盖原有数据，重写文件；
            //                        null--不写的话就相当于false，会覆盖掉原有数据
            fileWriter = new FileWriter(file,true);
            //写出操作
            fileWriter.write("GO on!\n");
            fileWriter.write("i will success!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //流资源的关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
