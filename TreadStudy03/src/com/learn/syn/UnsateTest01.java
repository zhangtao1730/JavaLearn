package com.learn.syn;

/**
 * 线程不安全：买票数据有负数，相同的情况
 * @author Administrator
 *
 */
public class UnsateTest01 {
	public static void main(String[] args) {
		//一份资源
		UnsafeWeb12306 web=new UnsafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"黄牛1").start();
		new Thread(web,"黄牛2").start();
		new Thread(web,"黄牛3").start();
	}
}

class UnsafeWeb12306 implements Runnable{
	//票数
	private int ticketNumbers=10;
	private boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			test();
		}
	}
	public void test(){
		if(ticketNumbers<0){
			flag=false;
			return;
		}
		//模拟演示
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNumbers--);
	}

}