package com.learn.status;

/**
 * yieldÀñÈÃÏß³Ì£¬ÔİÍ£Ïß³Ì£¬Ö±½Ó½øÈë¾ÍĞ÷×´Ì¬£¬²»ÊÇ×èÈû×´Ì¬
 * @author Administrator
 *
 */
public class YieldDemo01 {
	public static void main(String[] args) {
		MyYield my=new MyYield();
		new Thread(my,"a").start();
		new Thread(my,"b").start();
	}
}

class MyYield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->start");
		Thread.yield();//ÀñÈÃ
		System.out.println(Thread.currentThread().getName()+"--->end");
	}
	
}