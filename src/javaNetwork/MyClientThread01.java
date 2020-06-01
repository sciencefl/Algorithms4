package javaNetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClientThread01 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ObjectOutputStream oos = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            outputStream = socket.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            Student student = new Student(1002,"lss",24);
            oos.writeObject(student);
            socket.shutdownOutput();
            byte[] bytes= new byte[1024];
            inputStream=socket.getInputStream();
            int hasRead = -1;
            while((hasRead=inputStream.read(bytes))>0){
                System.out.println(new String(bytes,0,hasRead));
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                inputStream.close();
                oos.close();
                outputStream.close();
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
