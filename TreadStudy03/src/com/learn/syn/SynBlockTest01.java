package com.learn.syn;
/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����,Ŀ�����ȷ
 * @author Administrator
 *
 */
public class SynBlockTest01 {
	public static void main(String[] args) {
		//�˻�
		Account account=new Account(1000,"���");
		SynDrawing you=new SynDrawing(account,80,"��");
		SynDrawing wife=new SynDrawing(account,90,"��");
		you.start();
		wife.start();
	}
}


//ģ��ȡ���ȡ�� �̰߳�ȫ
class SynDrawing extends Thread{
	Account account;//ȡǮ�˻�
	int drawingMoney;//ȡ��Ǯ��
	int packetTotal;//�ڴ���Ǯ
	@Override
	public void run() {
		test();
	}
	public SynDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	//Ŀ������account
	public void test(){
		//�������
		if(account.money<=0){
			return;
		}
		//ͬ����
		synchronized(account){
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
	
}