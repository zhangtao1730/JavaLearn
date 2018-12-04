package com.sxt.io;

import java.io.File;

public class FileDemo01 {
	/**
	 * 构建file对象
	 * 相对路径与绝对路径
	 * 1.存在盘符：绝对路径
	 * 2.不存在盘符：相对路径,当前目录:user.dir
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="F:/workspace/IO_study01/src/IO.jpg";
		//绝对路径
		File src=new File(path);
		System.out.println(src.getAbsolutePath());
		//相对路径
		System.out.println(System.getProperty("user.dir"));
		src=new File("IO.jpg");
		System.out.println(src.getAbsolutePath());
		
		//构建一个不存在的文件
		src=new File("aaa/IO2.jpg");
		System.out.println(src.getAbsolutePath());
	}

}
