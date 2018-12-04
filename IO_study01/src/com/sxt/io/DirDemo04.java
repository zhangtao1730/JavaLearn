package com.sxt.io;

import java.io.File;

/**
 * �ݹ飺�����Լ������Լ�
 * ��ӡ���ＰĿ¼���ļ�������
 * 
 * �г������̷���listRoots
 * @author Administrator
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src=new File("F:/workspace/IO_study01");
		printName(src,0);
	}
	
	public static void printName(File src,int deep){
		//���Ʋ�θ�
		for(int i=0;i<deep;i++){
			System.out.print("-");
		}
		//��ӡ����
		System.out.println(src.getName());
		if(null==src||!src.exists()){//�ݹ�ͷ
			return;
		}else if(src.isDirectory()){
			for(File s:src.listFiles()){
				printName(s,deep+1);
			}
		}
	}
}
