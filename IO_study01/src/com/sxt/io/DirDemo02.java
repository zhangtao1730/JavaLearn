package com.sxt.io;

import java.io.File;

/**
 * �ݹ飺�����Լ������Լ�
 * �ݹ�ͷ����ʱ�����ݹ�
 * �ݹ��壺�ظ�����
 * �г������̷���listRoots
 * @author Administrator
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		printTen(1);
	}
	
	public static void printTen(int n){
		if(n>10){ //�ݹ�ͷ�������ݹ�
			return;
		}
		System.out.println(n);
		printTen(n+1);//�����Լ����Լ�
	}
		
}
