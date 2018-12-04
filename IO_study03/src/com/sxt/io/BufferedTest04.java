package com.sxt.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 四个步骤：分段读�? 文件字符输出�? 加入缓冲流
 * 1.创建�?
 * 2.选择�?
 * 3.操作
 * 4.释放资源
 * @author zhangtao
 *
 */
public class BufferedTest04 {
	public static void main(String[] args) {
		//1.创建�?
		File file=new File("text.txt");
		//2.选择�?
		BufferedWriter writer = null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			//3.操作
			//写法1
			String msg="天不生吕小树，万股剑道长如夜";
//			char[] data= msg.toCharArray();
//			writer.write(data, 0, data.length);
//			writer.flush();
			
			//写法2
//			writer.write(msg);
			writer.append(msg);
			writer.newLine();
			writer.append("this is a new line text");
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
