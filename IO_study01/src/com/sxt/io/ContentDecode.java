package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ַ���-->�ֽ�
 * @author Administrator
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg="���� ���� ʹ��";
		//����:�ֽ�����
		byte[] datas=msg.getBytes();//Ĭ��ʹ�ù��̵��ַ���
		System.out.println(datas.length);
		//���룺�����ַ���
		datas=msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
		datas=msg.getBytes("UTF-8");
		System.out.println(datas.length);
	}
}
