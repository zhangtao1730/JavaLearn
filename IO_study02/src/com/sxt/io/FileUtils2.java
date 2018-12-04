package com.sxt.io;

import java.io.Closeable;
import java.io.File;
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
public class FileUtils2 {
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
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is,OutputStream os){

		try {
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
		}finally{
			close(is,os);
		}
	}
	/**
	 * 释放资源
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is ,OutputStream os){
		//释放资源，分别关闭，先打开的后关闭
		try {
			if(os!=null){
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(is!=null){
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 释放资源
	 * @param ios
	 */
	public static void close(Closeable... ios){
		for(Closeable io:ios){
			try {
				if(io!=null){
					io.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
