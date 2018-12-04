package com.learn.syn;
/**
 * 线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author Administrator
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		//账户
		Account account=new Account(100,"礼金");
		SafeDrawing you=new SafeDrawing(account,80,"你");
		SafeDrawing wife=new SafeDrawing(account,90,"她");
		you.start();
		wife.start();
	}
}


//模拟取款机取款
class SafeDrawing extends Thread{
	Account account;//取钱账户
	int drawingMoney;//取得钱数
	int packetTotal;//口袋的钱
	@Override
	public void run() {
		test();
	}
	public SafeDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	//目标不对锁定失败 这里不是锁this 应该锁account
	public synchronized void test(){
		if(account.money-drawingMoney<0){
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"-->账户余额："+account.money);
		System.out.println(this.getName()+"-->口袋余额："+packetTotal);

	}
	
}