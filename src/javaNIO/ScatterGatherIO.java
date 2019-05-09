package javaNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/**
 * 分散/聚集函数IO的例子
 * @author Stone
 *
 */
public class ScatterGatherIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String data="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		ScatterGatherIO scatterGatherIO=new ScatterGatherIO();
		scatterGatherIO.gatherBytes(data);
		scatterGatherIO.scatterBytes();
	}
	public void gatherBytes(String data)  throws IOException{
		String relativelyPath=System.getProperty("user.dir");
		System.out.println(relativelyPath);
		ByteBuffer buffer1=ByteBuffer.allocate(16);
		ByteBuffer buffer2=ByteBuffer.allocate(128);
		buffer1.asIntBuffer().put(420);
		buffer2.asCharBuffer().put(data);
		System.out.println(relativelyPath);
		GatheringByteChannel gatheringByteChannel=createFileChannelInstance(relativelyPath+"/scatterGatherTest.txt",true);
		System.out.println(gatheringByteChannel.isOpen());
		try {
			gatheringByteChannel.write(new ByteBuffer[] {buffer1,buffer2});
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("eeee");
			e.printStackTrace();
		}
		gatheringByteChannel.close();
		
		
	}
	/**
	 * 分散函数，将文件中的  数据 写到buffer中，确实是 输入流
	 * @throws IOException
	 */
	public void scatterBytes()  throws IOException{
		String relativelyPath=System.getProperty("user.dir");
		ByteBuffer buffer1=ByteBuffer.allocate(8);
		ByteBuffer buffer2=ByteBuffer.allocate(400);
		ScatteringByteChannel scatteringByteChannel=createFileChannelInstance(relativelyPath+"/scatterGatherTest.txt",false);
		try {
			scatteringByteChannel.read(new ByteBuffer[] {buffer1,buffer2});
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		scatteringByteChannel.close();
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        // Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);


	}
	/**
	 * @param file 
	 * @param isOutput
	 * @return 返回一个创建 FileChannel的实例
	 * @throws IOException
	 */
	public FileChannel createFileChannelInstance(String file,boolean isOutput) throws IOException {
		FileChannel fileChannel=null;
		try {
			if(isOutput) {
				fileChannel=new FileOutputStream(new File(file)).getChannel();
			} else {
				fileChannel=new FileInputStream(new File(file)).getChannel();
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return fileChannel;
	}

}
