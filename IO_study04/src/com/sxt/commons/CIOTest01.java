package com.sxt.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 大小
 * @author Administrator
 *
 */
public class CIOTest01 {
	public static void main(String[] args) {
		//文件的大小
		long len=FileUtils.sizeOf(new File("IO.jpg"));
		System.out.println(len);
		//目录大小
		len=FileUtils.sizeOf(new File("F:/workspace/IO_study04"));
		System.out.println(len);
	}
}
