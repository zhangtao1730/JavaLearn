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
		 * \/���Ʒָ���separator
		 */
		String path="F:\\workspace\\IO_study01\\src\\IO.jpg";
		System.out.println(File.separatorChar);
		//����
		//1./
		path="F:/workspace/IO_study01/src/IO.jpg";
		//2����ƴ��
		path="F:"+File.separator+"workspace"+File.separator+"IO_study01"+File.separator+"src"+File.separator+"IO.jpg";
		System.out.println(path);
	}
}
