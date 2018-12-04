package com.sxt.io;

import java.io.File;

/**
 * 创建目录
 * 1.mkdir():确保上级目录存在，不存在创建失败
 * 2.mkdirs():上级目录可以不存在，不存在一同创建
 * @author Administrator
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir=new File("F:/workspace/IO_study01/dir/test");
		//创建目录
		boolean flag=dir.mkdirs();
		System.out.println(flag);
		dir=new File("F:/workspace/IO_study01/dir/test2");
		flag=dir.mkdir();
		System.out.println(flag);
	}
}
