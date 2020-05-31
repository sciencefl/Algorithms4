package javaIO;

import java.io.*;

public class FileInputStreamTest {
	// InputStream, OutStream 为抽象类
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//先创建一个输入流  输入流数据源为 FileInputStreamTest.java
		InputStream fileInputStream=null;
		OutputStream fileOutputStream=null;
		try {
			fileInputStream=new FileInputStream("./src/javaIO/FileInputStreamTest.java");
			//创建一个文件用于存储输出流
			fileOutputStream =new FileOutputStream("FileInputStreamTest.txt");
			//创建一个竹筒用于盛装 水滴
			byte[]  bbuf=new byte[1024];
			// 进行输出
			int hasRead=0; 
			while((hasRead=fileInputStream.read(bbuf))>0) {
				fileOutputStream.write(bbuf, 0, hasRead);
				//fileOutputStream.write(bbuf);
				System.out.println(new String(bbuf,0,hasRead));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fileInputStream!=null) {
				fileInputStream.close();
			}
			if(fileOutputStream!=null) {
				fileOutputStream.close();
			}
		}
	}
}
