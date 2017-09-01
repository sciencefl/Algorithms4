package Foundamentals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class BufferChannelTest {
/*
 * java NIO的练习
 * 
 * */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建buffer,容量为8个字符
		CharBuffer buff=CharBuffer.allocate(8);
		System.out.println("Buffer Capacity is:"+buff.capacity());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("Buffer Limit is:"+buff.limit());
		buff.put("abcdefg");
		System.out.println("After put \"abcdefg\" Buffer Postion is:"+buff.position());
		//调用flip方法为取数据做准备
		buff.flip();
		System.out.println("Buffer Capacity is:"+buff.capacity());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("Buffer Limit is:"+buff.limit());
		
		System.out.println("取数据0:"+buff.get());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("取数据0:"+buff.get(4));
		System.out.println("Buffer Postion is:"+buff.position());
		buff.clear();
		FileChannel inChannel=null;
		FileChannel outChannel=null;
		try {
			File file=new File("la.java");
			inChannel=new FileInputStream(file).getChannel();
			outChannel=new FileOutputStream("channel.txt").getChannel();
			//将inChannel 里的全部数据映射到ByteBuffer里面
			MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//将buffer里的数据全部输出到 channel.txt里面
			outChannel.write(buffer);
			//使用GBK字符集创建解码器
			Charset charset=Charset.forName("GBK");
			buffer.clear();
			//将解码器绑定到 GBK字符集
			CharsetDecoder decoder=charset.newDecoder();
			//字节到字符的转换需要用字符集的解码器来实现
			CharBuffer charBuffer=decoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try{
				if(inChannel!=null){
					inChannel.close();
				}
				if(outChannel!=null){
					outChannel.close();
				}
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}

		
	}

}
