package javaIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		ObjectOutputStream  objectOutputStream=null;
		try {
			objectOutputStream=new ObjectOutputStream(new FileOutputStream("PersionObject.txt"));
			PersionSerializable persionSerializable=new PersionSerializable("LaKers", 40);
			objectOutputStream.writeObject(persionSerializable);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(objectOutputStream!=null) {
				objectOutputStream.close();
			}
		}

	}

}
