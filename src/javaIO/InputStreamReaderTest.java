package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * 转换流实例
 * @author Stone
 *
 */
public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader=null;
		try {
			//将键盘输入的字节流转换为字符流 System.in
			InputStreamReader reader=new InputStreamReader(System.in);
			//将普通的 字符流Reader转换为  缓冲字符流 BufferedReader
			bReader=new BufferedReader(reader);
			String buffer=null;
			//一行一行的读取
			while((buffer=bReader.readLine())!=null) {
				//获取到 exit时退出
				if(buffer.equals("exit")) {
					System.exit(1);
				}
				System.out.println("输入内容为："+buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bReader!=null) {
				bReader.close();
			}
		}
	}

}
