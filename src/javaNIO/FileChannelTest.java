package javaNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileChannel inFileChannel=null;
		FileChannel outFileChannel=null;
		try {
			File file=new File("./src/javaIO/FileInputStreamTest.java");
			inFileChannel =new FileInputStream(file).getChannel();
			//将FileChannel里的数据全部映射成    ByteBuffer 1.
			MappedByteBuffer buffer=inFileChannel.map(FileChannel.MapMode.READ_ONLY,0, file.length());
			//使用GBK字符集来创建解码器
			Charset charset=Charset.forName("UTF-8");
			//创建文件输出流
			outFileChannel=new FileOutputStream(new File("outFileChannel.txt")).getChannel();
			//将ByteBuffer数据全部输出到FileChannel
			outFileChannel.write(buffer);
			buffer.clear();
			//创建解码器
			CharsetDecoder charsetDecoder=charset.newDecoder(); //采用GBK的格式解码
			CharBuffer charBuffer=charsetDecoder.decode(buffer);
			//CharBuffer的toString 方法可以直接输出字符串
			System.out.println(charBuffer);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			if(inFileChannel!=null) {
				inFileChannel.close();
			}
			if(outFileChannel!=null) {
				outFileChannel.close();
			}
		}
	}

}
