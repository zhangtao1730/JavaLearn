package com.learn.syn;
/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author Administrator
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		//�˻�
		Account account=new Account(100,"���");
		SafeDrawing you=new SafeDrawing(account,80,"��");
		SafeDrawing wife=new SafeDrawing(account,90,"��");
		you.start();
		wife.start();
	}
}


//ģ��ȡ���ȡ��
class SafeDrawing extends Thread{
	Account account;//ȡǮ�˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ���Ǯ
	@Override
	public void run() {
		test();
	}
	public SafeDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	//Ŀ�겻������ʧ�� ���ﲻ����this Ӧ����account
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
		System.out.println(this.getName()+"-->�˻���"+account.money);
		System.out.println(this.getName()+"-->�ڴ���"+packetTotal);

	}
	
}