package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 文件拷贝：文件字符输入输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author Administrator
 *
 */
public class CopyText {
	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		copy("abc.txt","copy.txt");
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	/**
	 * 文件的拷贝
	 * 思考：利用递归 制作文件夹的拷贝
	 * @param fromPath
	 * @param toPath
	 */
	public static void copy(String fromPath,String toPath){
		//1.创建源
		File from =new File(fromPath);
		File to =new File(toPath);
		
		try(BufferedReader is=new BufferedReader(new FileReader(from));
				BufferedWriter os=new BufferedWriter(new FileWriter(to))) {
			String line =null;
			while((line=is.readLine())!=null){
				os.write(line);
				os.newLine();
			}
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
