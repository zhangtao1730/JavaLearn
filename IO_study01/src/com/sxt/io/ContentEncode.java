package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节-->字符串
 * @author Administrator
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg="性命 生命 使命";
		//编码:字节数组
		byte[] datas=msg.getBytes();//默认使用工程的字符集
		//解码：字符串
		msg=new String(datas,0,datas.length,"GBK");
		System.out.println(msg);
		
		//乱码：
		//1）字节数不够
		msg=new String(datas,0,datas.length-2,"GBK");
		System.out.println(msg);
		msg=new String(datas,0,datas.length-1,"GBK");
		System.out.println(msg);
		//2)字符集不统一
		msg=new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
		
	}
}
