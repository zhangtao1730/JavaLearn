package com.sxt.io;

import java.io.File;

public class FileDemo01 {
	/**
	 * ����file����
	 * ���·�������·��
	 * 1.�����̷�������·��
	 * 2.�������̷������·��,��ǰĿ¼:user.dir
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="F:/workspace/IO_study01/src/IO.jpg";
		//����·��
		File src=new File(path);
		System.out.println(src.getAbsolutePath());
		//���·��
		System.out.println(System.getProperty("user.dir"));
		src=new File("IO.jpg");
		System.out.println(src.getAbsolutePath());
		
		//����һ�������ڵ��ļ�
		src=new File("aaa/IO2.jpg");
		System.out.println(src.getAbsolutePath());
	}

}
