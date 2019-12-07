package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现图片的复制功能
 */
public class fileInputOutputStreamTest {

    @Test
    public void testInputOutputStream(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //相对路径：相对于工程目录，就是相对于Java这个module来说的，Hebe.jpg这个文件就直接在它的下面
            File srcFile = new File("Hebe.jpg");
            //而反观这个路径，就要到Java中的src下找了
            File destFile = new File("src/zhaoyb.jpg");

            File JJFile = new File("src/io/JJ.jpg");
            //生成流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(JJFile);
            //图片的复制过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意看这里流关闭的写法
            if(fileInputStream != null){
                try{
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
