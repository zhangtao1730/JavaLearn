package com.learn.syn;

/**
 * 线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author Administrator
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		//一份资源
		SafeWeb12306 web=new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"黄牛1").start();
		new Thread(web,"黄牛2").start();
		new Thread(web,"黄牛3").start();
	}
}

class SafeWeb12306 implements Runnable{
	//票数
	private int ticketNumbers=10;
	private boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			//模拟延时
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test();
		}
	}
	//线程安全 同步
	public synchronized void test(){
		if(ticketNumbers<=0){
			flag=false;
			return;
		}
		//模拟延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNumbers--);
	}

}