package com.sxt.io;

import java.io.File;

/**
 * 其他信息
 * length():文件的字节数
 * @author Administrator
 *
 */
public class FileDemo06 {

	public static void main(String[] args) {
		File src=new File("F:/workspace/IO_study01/");
		System.out.println("长度："+src.length());
	}

}
