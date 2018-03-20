package Foundamentals;

import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import edu.princeton.cs.algs4.StaticSETofInts;

import java.io.*;

public class MainClass {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		File file=new File(".");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getAbsoluteFile().getParent());
//		//以系统当前时间作为新文件名来创建文件
//		File newFile = new File(System.currentTimeMillis()+"");
//		System.out.println("newFile对象文件是否存在："+newFile.exists());
////		newFile.createNewFile();
//		System.out.println("newFile对象文件是否存在："+newFile.exists());
//		String[] FileList=file.list();
//		for(String filename:FileList){
//			System.out.println(filename);
//		}
//		File[] roots=file.listRoots();
//		for(File fileroot: roots){
//			System.out.println(fileroot);
//		}
//		int hasRead=0;
//		FileInputStream fileinput= new FileInputStream("./src/Foundamentals/MainClass.java");
//		FileOutputStream fileoutput = new FileOutputStream("./NISHUOSHA.java");
//		byte[] b=new byte[1024];
//		while((hasRead=fileinput.read(b))>0){
//			//System.out.println(new String(b,0,hasRead));
//			//fileoutput.write(b,0,hasRead);
//			PrintStream ps=new PrintStream(fileoutput);
//			ps.write(b,0,hasRead);
//		}
//		fileinput.close();
//		fileoutput.close();
//		BufferedReader br=null;
//		try{
//		//转换流   将字节流转换为字符流
//			InputStreamReader  reader=new InputStreamReader(System.in);
//			//转换流 将字符流转换为 缓冲字符流
//			String buffer=null;
//			br=new BufferedReader(reader);
//			while((buffer=br.readLine())!=null){
//				if(buffer.equals("exit")){
//					System.exit(1);
//				}
//				System.out.println("输入内容为："+buffer+"\n");
//			}
//		}catch(IOException ioe){
//			ioe.printStackTrace();
//		}finally{
//			try{
//				br.close();
//			}catch(IOException ioe){
//			ioe.printStackTrace();
//			}
//		}
		//test2(0);
		//System.out.println(j);
		RandomAccessFile file =new RandomAccessFile("temp.dat", "rw");
		file.writeBoolean(true);
		file.writeInt(100);
		file.writeInt(12345);
		file.writeInt(6789);
		file.seek(5);
		System.out.println(file.readInt());
		double f=1.4;
		double h=Math.pow(f,27);
		System.out.println(h);

//			
	}
	private static int j=0;
	private static boolean test1(int k){
		j+=k;
		return true;
	}
	public static void test2(int i){
		boolean b;
		b=i<100|test1(3);
		b=1<010||test1(6);
	}
	

}
