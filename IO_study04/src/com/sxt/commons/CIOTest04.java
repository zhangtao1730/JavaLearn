package com.sxt.commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 写出内容
 * @author Administrator
 *
 */
public class CIOTest04 {
	public static void main(String[] args) throws IOException {
		//写出内容
		FileUtils.write(new File("happy.txt"), "沉迷学习无法自拔","utf-8",true);
	}
}
