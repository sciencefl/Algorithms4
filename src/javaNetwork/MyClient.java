package javaNetwork;

import javax.print.DocFlavor;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello ,server".getBytes());
            socket.shutdownOutput();
            inputStream=socket.getInputStream();
            reader = new BufferedReader( new InputStreamReader(inputStream));
            String info=null;
            while((info=reader.readLine())!=null){
                System.out.println("I am client,收到消息"+info);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(reader!=null) reader.close();
                if(inputStream!=null) inputStream.close();
                if(socket!=null) socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
