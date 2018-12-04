package com.sxt.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 四个步骤：分段读�? 文件字符输入�?加入缓冲流
 * 1.创建�?
 * 2.选择�?
 * 3.操作
 * 4.释放资源
 * @author zhangtao
 *
 */
public class BufferedTest03 {
	public static void main(String[] args) {
		//1.创建�?
		File file=new File("abc.txt");
		//2.选择�?
		BufferedReader reader = null;
		try {
			reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null){
				//字节数组-->字符�?
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
