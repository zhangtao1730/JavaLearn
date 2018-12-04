package com.sxt.io;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙及目录和文件的名称
 * 
 * 列出所有盘符：listRoots
 * @author Administrator
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src=new File("F:/workspace/IO_study01");
		printName(src,0);
	}
	
	public static void printName(File src,int deep){
		//控制层次感
		for(int i=0;i<deep;i++){
			System.out.print("-");
		}
		//打印名称
		System.out.println(src.getName());
		if(null==src||!src.exists()){//递归头
			return;
		}else if(src.isDirectory()){
			for(File s:src.listFiles()){
				printName(s,deep+1);
			}
		}
	}
}
