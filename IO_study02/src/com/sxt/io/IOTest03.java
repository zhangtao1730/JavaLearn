package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 四个步骤：分段读取 文件字节输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author zhangtao
 *
 */
public class IOTest03 {
	public static void main(String[] args) {
		File file=new File("abc.txt");
		InputStream is = null;
		try {
			is=new FileInputStream(file);
			byte[] flush = new byte[1023];//缓冲容器
			int len=-1;//接受长度
			while((len=is.read(flush))!=-1){
				//字节数组-->字符串
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}
}
