package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Java\\hello.txt");
        Socket socket = new Socket("localhost",8888);
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("444444444");

        int len;
        byte[] bytes = new byte[1024];
        while((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        System.out.println("5555555");

        InputStream in = socket.getInputStream();
        while((len = in.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }

        System.out.println("66666666666");

        fileInputStream.close();
        socket.close();
    }
}
