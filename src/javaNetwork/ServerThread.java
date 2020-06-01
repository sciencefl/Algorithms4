package javaNetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread{

    Socket socket = null;
    public  ServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
    //获取客户端数据
        InputStream in = null;
        ObjectInputStream ois= null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            ois= new ObjectInputStream(in);
            Student student = (Student)ois.readObject();
            System.out.println(student);
            socket.shutdownInput();

            //给客户端反馈
            out = socket.getOutputStream();
            out.write("已收到，谢谢".getBytes());
            socket.shutdownOutput();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                out.close();
                ois.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
