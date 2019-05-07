package javaIO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader frFileReader=null;
		try {
			frFileReader=new FileReader("./src/javaIO/FileInputStreamTest.java");
			char[] cbuf=new char[64];
			int hasRead=0;
			while((hasRead=frFileReader.read(cbuf))>0) {
				System.out.println(new String(cbuf,0,hasRead));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(frFileReader!=null) {
				frFileReader.close();
			}
		}
	}

}
