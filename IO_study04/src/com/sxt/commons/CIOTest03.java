package com.sxt.commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * ��ȡ����
 * @author Administrator
 *
 */
public class CIOTest03 {
	public static void main(String[] args) throws IOException {
		//��ȡ�ļ�
		String msg=FileUtils.readFileToString(new File("emp.txt"),"utf-8");
		System.out.println(msg);
		byte[] datas=FileUtils.readFileToByteArray(new File("emp.txt"));
		System.out.println(datas.length);
	}
}
