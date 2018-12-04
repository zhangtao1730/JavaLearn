package com.learn.thread;
/**
 * lambda推导
 * @author zhangtao
 *
 */
public class LambdaTest04 {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("一边学习lambda");
		}).start();
		
		new Thread(()->System.out.println("一边学习崩溃")).start();
	}

}
