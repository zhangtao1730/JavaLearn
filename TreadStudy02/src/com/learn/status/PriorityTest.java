package com.learn.status;

/**
 * 线程的优先级 1-10
 * @author Administrator
 * 1.NORM_PRIORITY 5 默认
 * 2.MIN_PRIORITY 1
 * 3.MAX_PRIORITY 10
 * 概率，不代表绝对的先后顺序
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		MyPriority mp=new MyPriority();
		Thread t1=new Thread(mp,"adidas");
		Thread t2=new Thread(mp,"nike");
		Thread t3=new Thread(mp,"回力");
		Thread t4=new Thread(mp,"李宁");
		Thread t5=new Thread(mp,"双星");
		Thread t6=new Thread(mp,"puma");
		//设置在启动之前
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}