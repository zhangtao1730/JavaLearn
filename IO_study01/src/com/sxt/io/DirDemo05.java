package com.sxt.io;

import java.io.File;

/**
 * ͳ���ļ��еĴ�С
 * 
 * �г������̷���listRoots
 * @author Administrator
 *
 */
public class DirDemo05 {
	public static void main(String[] args) {
		File src=new File("F:/workspace/IO_study01");
		count(src);
		System.out.println(len);
	}
	private static long len=0;
	public static void count(File src){
		//��ȡ��С
		if(null!=src&&src.exists()){
			if(src.isFile()){//��С
				len+=src.length();
			}else{//���Ｖ
				for(File s:src.listFiles()){
					count(s);
				}
			}
		}
	}
}
