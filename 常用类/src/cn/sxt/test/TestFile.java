package cn.sxt.test;

import java.io.File;
import java.io.IOException;

/**
 * 测试File类的基本用法
 * @author Administrator
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		File f=new File("d:/a.txt");

		
		System.out.println(f);
		f.renameTo(new File("d:/bb.txt"));
		System.out.println(System.getProperty("user.dir"));

		File f2=new File("gg.txt");
		f2.createNewFile();
		
		
	}
}
