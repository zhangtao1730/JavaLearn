package com.sxt.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * ��С
 * @author Administrator
 *
 */
public class CIOTest01 {
	public static void main(String[] args) {
		//�ļ��Ĵ�С
		long len=FileUtils.sizeOf(new File("IO.jpg"));
		System.out.println(len);
		//Ŀ¼��С
		len=FileUtils.sizeOf(new File("F:/workspace/IO_study04"));
		System.out.println(len);
	}
}
