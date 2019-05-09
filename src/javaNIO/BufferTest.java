package javaNIO;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Buffer
		CharBuffer buffer=CharBuffer.allocate(8);
		System.out.println("capacity:"+buffer.capacity());
		System.out.println("position:"+buffer.position());
		System.out.println("limit:"+buffer.limit());
		//放入元素
		buffer.put("a");
		buffer.put("b");
		buffer.put("c");
		System.out.println("放入三个元素后：");
		System.out.println(" capacity:"+buffer.capacity());
		System.out.println("position:"+buffer.position());
		System.out.println("limit:"+buffer.limit());
		//调用flip 后
		buffer.flip();
		System.out.println("调用filp后：");
		System.out.println(" capacity:"+buffer.capacity());
		System.out.println("position:"+buffer.position());
		System.out.println("limit:"+buffer.limit());
		System.out.println(buffer.get());
		System.out.println(buffer.get());
		System.out.println("取出一个元素后：position:"+buffer.position());
		buffer.clear();
		System.out.println("调用clear后：");
		System.out.println(" capacity:"+buffer.capacity());
		System.out.println("position:"+buffer.position());
		System.out.println("limit:"+buffer.limit());
		buffer.get(2);
		System.out.println("position:"+buffer.position());

	}

}
