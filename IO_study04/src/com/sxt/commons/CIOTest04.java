package com.sxt.commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * д������
 * @author Administrator
 *
 */
public class CIOTest04 {
	public static void main(String[] args) throws IOException {
		//д������
		FileUtils.write(new File("happy.txt"), "����ѧϰ�޷��԰�","utf-8",true);
	}
}
