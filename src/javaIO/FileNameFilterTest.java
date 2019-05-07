package javaIO;

import java.io.File;

/**
 * 文件过滤器类，要实现在java.io包下的FilenameFilter接口
 * @author Stone
 *
 */
public class FileNameFilterTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File(".");
		String[] list=file.list(new MyFilenameFilter());
		for(String namelist: list) {
			System.out.println(namelist);
		}

	}

}

class MyFilenameFilter implements java.io.FilenameFilter{
	/**
	 * 返回以  .java 结尾 或者以文件路径为结尾的话，返回true。
	 */
	public boolean accept(File dir,String name) {
		return name.endsWith(".java")| new File(name).isDirectory();
	}
}
