package com.sxt.io;

import java.io.File;

/**
 * ʹ���������ͳ���ļ��еĴ�С
 * 
 * �г������̷���listRoots
 * @author Administrator
 *
 */
public class DirCount {
	//��С
	private long len;
	//�ļ���
	private String path;
	//Դ
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
	//ͳ�ƴ�С
	private void count(File src){
		//��ȡ��С
		if(null!=src&&src.exists()){
			if(src.isFile()){//��С
				len+=src.length();
			}else{//���Ｖ
				for(File s:src.listFiles()){
					count(s);
				}
			}
		}
	}
}
