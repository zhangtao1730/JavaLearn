package com.learn.thread;
/**
 * lambda�Ƶ�
 * @author zhangtao
 *
 */
public class LambdaTest04 {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("һ��ѧϰlambda");
		}).start();
		
		new Thread(()->System.out.println("һ��ѧϰ����")).start();
	}

}
