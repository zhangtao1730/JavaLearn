package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * createNewFile():�����ڲŴ���
 * delete():ɾ���Ѿ����ڵ��ļ�
 * @author Administrator
 *
 */
public class FileDemo05 {

	public static void main(String[] args) throws IOException {
		File src=new File("F:/workspace/IO_study01/io.txt");
		boolean flag=src.createNewFile();
		System.out.println(flag);
		flag=src.delete();
		System.out.println(flag);
	}

}
