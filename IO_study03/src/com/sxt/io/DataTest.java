package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流
 * 1.写出后读取
 * 2.读取的顺序与写出保持一致
 * DataInputStream
 * DataOutputStream
 * @author Administrator
 *
 */
public class DataTest {
	public static void main(String[] args) throws IOException {
		//先写出
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型
		dos.writeUTF("天不生仲尼，万古长如夜");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas=baos.toByteArray();
		//读取
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一致
		String msg=dis.readUTF();
		int age=dis.readInt();
		boolean flag=dis.readBoolean();
		char ch=dis.readChar(); 
		System.out.println(flag);
	}
}
