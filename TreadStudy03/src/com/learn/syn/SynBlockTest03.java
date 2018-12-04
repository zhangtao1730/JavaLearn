package com.learn.syn;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author Administrator
 *
 */
public class SynBlockTest03 {
	public static void main(String[] args) {
		//һ����Դ
		SynWeb12306 web=new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"��ţ1").start();
		new Thread(web,"��ţ2").start();
		new Thread(web,"��ţ3").start();
	}
}

class SynWeb12306 implements Runnable{
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
			test5();
		}
	}
	
	//�̰߳�ȫ����������������ķ�Χ(����ָ���� ָ���ݵ�������)
	//˫�ؼ�� double checking
	public  void test5(){
		if(ticketNumbers<=0){//���ǵ���û��Ʊ�����
			flag=false;
			return;
		}
		synchronized(this){
			if(ticketNumbers<=0){//���ǵ�ʱ����һ��Ʊ
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
	
	
	//�̲߳���ȫ ��Χ̫С����ס
	public void test4(){
		synchronized(this){
			if(ticketNumbers<=0){
				flag=false;
				return;
			}
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
	
	
	//�̲߳���ȫ ticketNumbers�����ڱ�
	public  void test3(){
		synchronized((Integer)ticketNumbers){
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
	
	//�̰߳�ȫ ��Χ̫��-->Ч�ʵ���
	public  void test2(){
		synchronized(this){
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
	
	//�̰߳�ȫ ͬ��
	public synchronized void test1(){
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