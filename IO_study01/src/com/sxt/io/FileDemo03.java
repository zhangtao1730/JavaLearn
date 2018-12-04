package com.sxt.io;

import java.io.File;

/**
 * 名称或路径
 * getName():名称
 * getPath():根据构建返回绝对，相对
 * getAbsolutePath()：绝对
 * getParent()：上路径不存在返回null
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		File src=new File("IO.jpg");
		//基本信息
		System.out.println("名称:"+src.getName());
		System.out.println("路径："+src.getPath());
		System.out.println("绝对路径："+src.getAbsolutePath());
		System.out.println("父路经:"+src.getParent());
		System.out.println("父对象"+src.getParentFile());
	}
}
