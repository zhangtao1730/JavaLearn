package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个程序：理解操作步骤(标准)
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author zhangtao
 *
 */
public class IOTest02 {
	public static void main(String[] args) {
		File file=new File("abc.txt");
		InputStream is = null;
		try {
			is=new FileInputStream(file);
			int temp;
			while((temp=is.read())!=-1){
				System.out.print((char)temp);
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
