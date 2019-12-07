package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Java\\hello11111.txt");

        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("1111111");

//        byte[] bytes = new byte[1024];
//        int len;
//        while((len = inputStream.read(bytes)) != -1){
//            fileOutputStream.write(bytes,0,len);
//        }

        System.out.println("222222");

        socket.getOutputStream().write("上传成功".getBytes());

        System.out.println("3333333");

        fileOutputStream.close();
        serverSocket.close();
        socket.close();
    }
}
