package Foundamentals;

import java.io.*;

public class InInsertContent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		insertContent("la.java",0,"RandomAccessFile test\r\n");
	}
	public static void insertContent(String fileName,long pos,String insertContent) throws IOException{
		RandomAccessFile raf=null;
		//����һ����ʱ�ļ��洢��������
		File tmp= File.createTempFile("tmp",null);
		FileInputStream fileInput=null;
		FileOutputStream fileOutput =null;
		tmp.deleteOnExit();
		try{
			raf=new RandomAccessFile(fileName,"rw");
			fileInput =new FileInputStream(tmp);
			fileOutput =new FileOutputStream(tmp);
			raf.seek(pos);
			//��pos��������ݴ洢��tmp�ļ���
			int hasRead=0;
			byte[] bbuf=new byte[1024];
			while((hasRead=raf.read(bbuf))>0){
				fileOutput.write(bbuf,0, hasRead);
			}
			//����Ҫ���������
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			//��tmp�е�����׷�ӻ���
			while((hasRead=fileInput.read(bbuf))>0){
				raf.write(bbuf, 0, hasRead);
			}
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			raf.close();
		}
	}

}
