package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.图片读取到字节数组中
 * 2.将字节数组写出到文件
 * @author zhangtao
 *
 */
public class IOTest09 {
	public static void main(String[] args) {
		byte[] datas=fileToByteArray("IO.jpg");
		System.out.println(datas.length);
		byteArrayToFile(datas,"IO-copy.jpg");
	}
	/**
	 * 图片读取到字节数组
	 * 1.图片到程序 FileInputStream
	 * 2.图片到字节数组 ByteArrayOutputStram
	 * @param filePath
	 */
	@SuppressWarnings("null")
	public static byte[] fileToByteArray(String filePath){
		//1.创建源与目的地
		File file = new File(filePath);
		byte[] dest =null;
		//2.选择流
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			//3.操作
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1){
				baos.write(flush, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(is!=null){
					is.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 字节数组写出到图片
	 * 1.字节数组读取到程序中ByteArrayInputStream
	 * 2.程序写出到文件FileOutStream
	 * @param src
	 * @param filePath
	 */
	public static void byteArrayToFile(byte[] src,String filePath){
		File file =new File(filePath);
		ByteArrayInputStream bais=null;
		OutputStream os=null;
		
		try {
			bais=new ByteArrayInputStream(src);
			os=new FileOutputStream(file);
			int len=-1;
			while((len=bais.read(src))!=-1){
				os.write(src, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(os!=null){
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
