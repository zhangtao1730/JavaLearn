package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 四个步骤：分段读取字节数组输出流
 * 1.创建源：内部维护
 * 2.选择流：不关联源
 * 3.操作
 * 4.释放资源：可以不用处理
 * 
 * 获取数据：toByteArray()
 * @author zhangtao
 *
 */
public class IOTest07 {
	public static void main(String[] args) {
		//1.创建源
		byte[] dest=null;
		//2.选择流(新增方法)
		ByteArrayOutputStream baos = null;
		try {
			baos=new ByteArrayOutputStream();
			//3.操作
			String msg="show me the code";
			byte[] datas=msg.getBytes();
			baos.write(datas, 0, msg.length());
			baos.flush();
			//获取数据
			dest=baos.toByteArray();
			System.out.println(dest.length+"-->"+ new String(dest,0,baos.size()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4.释放资源（不需要）
			try {
				if(baos!=null){
					baos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
