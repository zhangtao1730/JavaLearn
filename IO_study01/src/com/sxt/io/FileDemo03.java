package com.sxt.io;

import java.io.File;

/**
 * ���ƻ�·��
 * getName():����
 * getPath():���ݹ������ؾ��ԣ����
 * getAbsolutePath()������
 * getParent()����·�������ڷ���null
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		File src=new File("IO.jpg");
		//������Ϣ
		System.out.println("����:"+src.getName());
		System.out.println("·����"+src.getPath());
		System.out.println("����·����"+src.getAbsolutePath());
		System.out.println("��·��:"+src.getParent());
		System.out.println("������"+src.getParentFile());
	}
}
