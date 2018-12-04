package com.learn.syn;
/**
 * 线程不安全：取钱
 * @author Administrator
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		//账户
		Account account=new Account(100,"礼金");
		Drawing you=new Drawing(account,80,"你");
		Drawing wife=new Drawing(account,90,"她");
		you.start();
		wife.start();
	}
}

//模拟取款机取款
class Drawing extends Thread{
	Account account;//取钱账户
	int drawingMoney;//取得钱数
	int packetTotal;//口袋的钱
	@Override
	public void run() {
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
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
}