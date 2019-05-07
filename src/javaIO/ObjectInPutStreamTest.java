package javaIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * 反序列化
 * @author Stone
 *
 */
public class ObjectInPutStreamTest {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		ObjectInputStream  objectInputStream=null;
		try {
			objectInputStream=new ObjectInputStream(new FileInputStream("PersionObject.txt"));
			PersionSerializable persionSerializable=(PersionSerializable)objectInputStream.readObject();
			System.out.println(persionSerializable.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(objectInputStream!=null) {
				objectInputStream.close();
			}
		}

	}

}
