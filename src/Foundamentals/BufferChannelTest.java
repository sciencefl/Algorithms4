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
 * java NIO����ϰ
 * 
 * */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����buffer,����Ϊ8���ַ�
		CharBuffer buff=CharBuffer.allocate(8);
		System.out.println("Buffer Capacity is:"+buff.capacity());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("Buffer Limit is:"+buff.limit());
		buff.put("abcdefg");
		System.out.println("After put \"abcdefg\" Buffer Postion is:"+buff.position());
		//����flip����Ϊȡ������׼��
		buff.flip();
		System.out.println("Buffer Capacity is:"+buff.capacity());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("Buffer Limit is:"+buff.limit());
		
		System.out.println("ȡ����0:"+buff.get());
		System.out.println("Buffer Postion is:"+buff.position());
		System.out.println("ȡ����0:"+buff.get(4));
		System.out.println("Buffer Postion is:"+buff.position());
		buff.clear();
		FileChannel inChannel=null;
		FileChannel outChannel=null;
		try {
			File file=new File("la.java");
			inChannel=new FileInputStream(file).getChannel();
			outChannel=new FileOutputStream("channel.txt").getChannel();
			//��inChannel ���ȫ������ӳ�䵽ByteBuffer����
			MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//��buffer�������ȫ������� channel.txt����
			outChannel.write(buffer);
			//ʹ��GBK�ַ�������������
			Charset charset=Charset.forName("GBK");
			buffer.clear();
			//���������󶨵� GBK�ַ���
			CharsetDecoder decoder=charset.newDecoder();
			//�ֽڵ��ַ���ת����Ҫ���ַ����Ľ�������ʵ��
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
