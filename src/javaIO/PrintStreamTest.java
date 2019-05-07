package javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 处理流的简单应用
 * @author Stone
 *
 */

public class PrintStreamTest {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建一个节点流
		FileOutputStream file=null;
		PrintStream psPrintStream=null;
		
		try {
			file=new FileOutputStream("PrintStreamTest.txt");
			psPrintStream=new PrintStream(file);
			psPrintStream.println("处理流");
			psPrintStream.print(new PrintStreamTest());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(psPrintStream!=null) {
				psPrintStream.close();
			}
		}
	}

}
