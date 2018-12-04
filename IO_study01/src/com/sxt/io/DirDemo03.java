package com.sxt.io;

import java.io.File;

/**
 * �г���һ��
 * 1.list():�г��¼�����
 * 2.listFiles():�г��¼�File����
 * 
 * �г������̷���listRoots
 * @author Administrator
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		File dir=new File("F:/workspace/IO_study01");
		//�г��¼����� list
		String[] subNames=dir.list();
		for(String s:subNames){
			System.out.println(s);
		}
		
		//�¼����� list Files()
		File[] subFiles=dir.listFiles();
		for(File s:subFiles){
			System.out.println(s.getAbsolutePath());
		}
		
		File[] roots = dir.listRoots();
		for(File r:roots){
			System.out.println(r.getAbsolutePath());
		}
	}
}
