package com.sxt.io;

import java.io.File;

/**
 * 列出下一级
 * 1.list():列出下级名称
 * 2.listFiles():列出下级File对象
 * 
 * 列出所有盘符：listRoots
 * @author Administrator
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		File dir=new File("F:/workspace/IO_study01");
		//列出下级名称 list
		String[] subNames=dir.list();
		for(String s:subNames){
			System.out.println(s);
		}
		
		//下级对象 list Files()
		File[] subFiles=dir.listFiles();
		for(File s:subFiles){
			System.out.println(s.getAbsolutePath());
		}
		
		File[] roots = dir.listRoots();
		for(File r:roots){
			System.out.println(r.getAbsolutePath());
		}
	}
}
