package com.learn.status;

/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * @author Administrator
 *
 */
public class BlockedSleep01 {
	public static void main(String[] args) {
		//一份资源
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"黄牛1").start();
		new Thread(web,"黄牛2").start();
		new Thread(web,"黄牛3").start();
	}
	
}

class Web12306 implements Runnable{
	//票数
	private int ticketNumbers=99;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(ticketNumbers<0){
				break;
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

}