package com.sxt.io;

import java.io.File;

/**
 * 
 * @author Administrator
 *
 */
public class PathDemo01 {
	public static void main(String[] args) {
		/**
		 * \/名称分隔符separator
		 */
		String path="F:\\workspace\\IO_study01\\src\\IO.jpg";
		System.out.println(File.separatorChar);
		//建议
		//1./
		path="F:/workspace/IO_study01/src/IO.jpg";
		//2常量拼接
		path="F:"+File.separator+"workspace"+File.separator+"IO_study01"+File.separator+"src"+File.separator+"IO.jpg";
		System.out.println(path);
	}
}
