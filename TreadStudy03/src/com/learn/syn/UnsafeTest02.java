package com.learn.syn;
/**
 * �̲߳���ȫ��ȡǮ
 * @author Administrator
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		//�˻�
		Account account=new Account(100,"���");
		Drawing you=new Drawing(account,80,"��");
		Drawing wife=new Drawing(account,90,"��");
		you.start();
		wife.start();
	}
}

//ģ��ȡ���ȡ��
class Drawing extends Thread{
	Account account;//ȡǮ�˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ���Ǯ
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
		System.out.println(this.getName()+"-->�˻���"+account.money);
		System.out.println(this.getName()+"-->�ڴ���"+packetTotal);
	}
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
}