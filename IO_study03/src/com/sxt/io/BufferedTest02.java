package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * 字节输出�?加入缓冲流
 * 1.创建�?
 * 2.选择�?
 * 3.操作（写出内容）
 * 4.释放资源
 * @author Administrator
 *
 */
public class BufferedTest02 {
	public static void main(String[] args) {
		File file =new File("test2");
		OutputStream os=null;
		
		try {
			os=new BufferedOutputStream(new FileOutputStream(file,true));
			String msg="this is the second test file for IO outputStream!\r\n";
			byte[] data=msg.getBytes();
			os.write(data, 0, msg.length());
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
