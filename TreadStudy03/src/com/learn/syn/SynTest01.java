package com.learn.syn;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author Administrator
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		//һ����Դ
		SafeWeb12306 web=new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"��ţ1").start();
		new Thread(web,"��ţ2").start();
		new Thread(web,"��ţ3").start();
	}
}

class SafeWeb12306 implements Runnable{
	//Ʊ��
	private int ticketNumbers=10;
	private boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			//ģ����ʱ
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test();
		}
	}
	//�̰߳�ȫ ͬ��
	public synchronized void test(){
		if(ticketNumbers<=0){
			flag=false;
			return;
		}
		//ģ����ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNumbers--);
	}

}