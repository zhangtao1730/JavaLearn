package com.sxt.io;

import java.io.File;

/**
 * �ļ�״̬
 * 1.������:exists
 * 2.����
 * 	�ļ�isFile
 * 	�ļ��� isDirectory
 * @author Administrator
 *
 */
public class FileDemo04 {
	public static void main(String[] args) {
		File src=new File("IO_study01/IO.jpg");
		System.out.println("�Ƿ����:"+src.exists());
		System.out.println("�Ƿ��ļ���:"+src.isDirectory());
		System.out.println("�Ƿ��ļ�:"+src.isFile());
		System.out.println("------");
		src=new File("IO.jpg");
		System.out.println("�Ƿ����:"+src.exists());
		System.out.println("�Ƿ��ļ���:"+src.isDirectory());
		System.out.println("�Ƿ��ļ�:"+src.isFile());
		System.out.println("------");
		src=new File("IO_study01");
		System.out.println("�Ƿ����:"+src.exists());
		System.out.println("�Ƿ��ļ���:"+src.isDirectory());
		System.out.println("�Ƿ��ļ�:"+src.isFile());
		System.out.println("------");
		src=new File("F:/workspace/IO_study01/");
		System.out.println("�Ƿ����:"+src.exists());
		System.out.println("�Ƿ��ļ���:"+src.isDirectory());
		System.out.println("�Ƿ��ļ�:"+src.isFile());
		src=new File("xxx");
		if(null==src||!src.exists()){
			System.out.println("�ļ�������");
		}else{
			if(src.isFile()){
				System.out.println("�ļ�����");
			}else{
				System.out.println("�ļ��в���");
			}
		}
	}
}
