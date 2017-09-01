package Foundamentals;

import java.util.Scanner;
import java.io.*;

public class MainClass {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file=new File(".");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile().getParent());
		//��ϵͳ��ǰʱ����Ϊ���ļ����������ļ�
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile�����ļ��Ƿ���ڣ�"+newFile.exists());
//		newFile.createNewFile();
		System.out.println("newFile�����ļ��Ƿ���ڣ�"+newFile.exists());
		String[] FileList=file.list();
		for(String filename:FileList){
			System.out.println(filename);
		}
		File[] roots=file.listRoots();
		for(File fileroot: roots){
			System.out.println(fileroot);
		}
		int hasRead=0;
		FileInputStream fileinput= new FileInputStream("./src/Foundamentals/MainClass.java");
		FileOutputStream fileoutput = new FileOutputStream("./NISHUOSHA.java");
		byte[] b=new byte[1024];
		while((hasRead=fileinput.read(b))>0){
			//System.out.println(new String(b,0,hasRead));
			//fileoutput.write(b,0,hasRead);
			PrintStream ps=new PrintStream(fileoutput);
			ps.write(b,0,hasRead);
		}
		fileinput.close();
		fileoutput.close();
		BufferedReader br=null;
		try{
		//ת����   ���ֽ���ת��Ϊ�ַ���
			InputStreamReader  reader=new InputStreamReader(System.in);
			//ת���� ���ַ���ת��Ϊ �����ַ���
			String buffer=null;
			br=new BufferedReader(reader);
			while((buffer=br.readLine())!=null){
				if(buffer.equals("exit")){
					System.exit(1);
				}
				System.out.println("��������Ϊ��"+buffer+"\n");
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				br.close();
			}catch(IOException ioe){
			ioe.printStackTrace();
			}
		}
		
	}

}
