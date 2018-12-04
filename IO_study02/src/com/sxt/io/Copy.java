package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 文件拷贝：文件字符输入输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author Administrator
 *
 */
public class Copy {
	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		copy("F:/workspace/IO_study03/166_IO_开篇.mp4","IO_开篇.mp4");
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
		
		try(InputStream is=new BufferedInputStream(new FileInputStream(from));
				OutputStream os=new BufferedOutputStream(new FileOutputStream(to))) {
			int len=-1;
			byte[] flush=new byte[1024];
			while((len=is.read(flush))!=-1){
				os.write(flush, 0, len);
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
