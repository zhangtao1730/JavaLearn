package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ֽ�-->�ַ���
 * @author Administrator
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg="���� ���� ʹ��";
		//����:�ֽ�����
		byte[] datas=msg.getBytes();//Ĭ��ʹ�ù��̵��ַ���
		//���룺�ַ���
		msg=new String(datas,0,datas.length,"GBK");
		System.out.println(msg);
		
		//���룺
		//1���ֽ�������
		msg=new String(datas,0,datas.length-2,"GBK");
		System.out.println(msg);
		msg=new String(datas,0,datas.length-1,"GBK");
		System.out.println(msg);
		//2)�ַ�����ͳһ
		msg=new String(datas,0,datas.length,"utf8");
		System.out.println(msg);
		
	}
}
