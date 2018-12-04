package com.sxt.io;

import java.io.File;

/**
 * 使用面向对象统计文件夹的大小
 * 
 * 列出所有盘符：listRoots
 * @author Administrator
 *
 */
public class DirCount {
	//大小
	private long len;
	//文件夹
	private String path;
	//源
	private File src;
	public DirCount(String path){
		this.path=path;
		this.src=new File(path);
		count(this.src);
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public static void main(String[] args) {
		DirCount dir=new DirCount("F:/workspace/IO_study01");
		System.out.println(dir.getLen());
	}
	//统计大小
	private void count(File src){
		//获取大小
		if(null!=src&&src.exists()){
			if(src.isFile()){//大小
				len+=src.length();
			}else{//子孙级
				for(File s:src.listFiles()){
					count(s);
				}
			}
		}
	}
}
