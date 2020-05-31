package javaNetwork;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        OutputStream outputStream = null;
//    1. 准备连接：ip默认本机127.0.0.1，端口8888
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动");
            //准备完毕，可以发送请求，accept() 用于监听客户端请求 返回一个socket
            socket=serverSocket.accept();//一直阻塞，直到有客户端连接
            System.out.println("服务器监测到客户端连接成功");
//    2. 通过socket，生成inputstream，outputstream（准备发送数据）
            inputStream = socket.getInputStream();
            //带缓冲区的字符流（字节流 转换为 字符流）
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String info=null;
            while((info=reader.readLine())!=null){
                System.out.println("I am server,收到消息"+info);
            }
            socket.shutdownInput();
            //服务端反馈
            outputStream = socket.getOutputStream();
            outputStream.write("welcome client".getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*
             *    1先关出，再关入
             *    2从外往内关  br外 = new BufferedReader( reader内) ;
             * */
            try {
                if(outputStream!=null) outputStream.close();
                if(reader!=null) reader.close();
                if(inputStream!=null) inputStream.close();
                if(socket!=null) socket.close();
                if(serverSocket!=null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

//    3. 使用inputstream，outputstream进行发送、接收数据
//    4. 关闭inputstream，outputstream、socket
    }

}
