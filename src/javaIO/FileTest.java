package javaIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File类代表的是java.io包下与平台无关的文件和目录，如果在程序中希望操作文件和目录都可用File类来实现。
 * File类可以 新建、删除和重命名文件和目录，File类不能访问文件本身，如果需要访问文件本身，需要使用 IO流。
 * @param args
 */
public class FileTest {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//可以使用文件路径字符串来创建 File实例，可以是绝对路径，也可以是相对路径
		File file  =new File(".");
		//获取文件名，输出一点
		System.out.println(file.getName());
		// 获取相对路径上级路径 的名称，这里为空
		System.out.println(file.getParent());
		//获取绝对路径的地址 为workspace的地址 user.dir
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile().getParent());
		// 在当前路径下创建临时文件
		File tempFile=File.createTempFile("aaa", ".zzz",file);
		// 以系统当前时间为新文件名称创建文件
		File newFile=new File(System.currentTimeMillis()+"");
		System.out.println(newFile.getName());
		System.out.println("newFile是否存在？"+newFile.exists());
		newFile.createNewFile();
		System.out.println("newFile是否存在？"+newFile.exists());
		//列出所有子文件名和路径名
		String[] liStrings=file.list();
		System.out.println("=========当前路径下的所有文件和路径");
		for(String fileName:liStrings) {
			System.out.println(fileName);
		}
		File[] liRoots=File.listRoots();
		System.out.println("=========当前路径下的根路径");
		for(File root:liRoots) {
			System.out.println(root);
		}
		
	}

}
