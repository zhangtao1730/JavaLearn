package com.sxt.io;

import java.io.File;

public class FileDemo02 {
	/**
	 * ����file����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="F:/workspace/IO_study01/src/IO.jpg";
		//1.����file����
		File src=new File(path);
		System.out.println(src.length());
		
		//2.����file����
		src=new File("F:/workspace/IO_study01/src/","IO.jpg");
		System.out.println(src.length());
		
		//3.����file����
		src=new File(new File("F:/workspace/IO_study01/src/"),"IO.jpg");
		System.out.println(src.length());
	}

}
