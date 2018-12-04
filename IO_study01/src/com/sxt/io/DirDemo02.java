package com.sxt.io;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 递归头：何时结束递归
 * 递归体：重复调用
 * 列出所有盘符：listRoots
 * @author Administrator
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		printTen(1);
	}
	
	public static void printTen(int n){
		if(n>10){ //递归头：结束递归
			return;
		}
		System.out.println(n);
		printTen(n+1);//方法自己调自己
	}
		
}
