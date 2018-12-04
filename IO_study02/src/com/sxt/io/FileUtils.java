package com.sxt.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1封装拷贝
 * 2封装释放
 * @author zhangtao
 *
 */
public class FileUtils {
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is=new FileInputStream("abc.txt");
			OutputStream os =new FileOutputStream("abc_copy.txt");
			copy(is,os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对接输入输出流
	 * try...with...resouce
	 * @param <is>
	 * @param <os>
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is,OutputStream os){
//		try(is;os;) {
//			int len=-1;
//			byte[] flush=new byte[1024];
//			while((len=is.read(flush))!=-1){
//				os.write(flush, 0, len);
//			}
//			os.flush();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


}
