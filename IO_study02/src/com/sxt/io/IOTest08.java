package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 四个步骤：分段读取 文件字符输出流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author zhangtao
 *
 */
public class IOTest08 {
	public static void main(String[] args) {
		//1.创建源
		File file=new File("text.txt");
		//2.选择流
		Writer writer = null;
		try {
			writer=new FileWriter(file);
			//3.操作
			//写法1
			String msg="天不生吕小树，万股剑道长如夜";
//			char[] data= msg.toCharArray();
//			writer.write(data, 0, data.length);
//			writer.flush();
			
			//写法2
			writer.write(msg);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
