package com.learn.syn;

/**
 * �̲߳���ȫ����Ʊ�����и�������ͬ�����
 * @author Administrator
 *
 */
public class UnsateTest01 {
	public static void main(String[] args) {
		//һ����Դ
		UnsafeWeb12306 web=new UnsafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"��ţ1").start();
		new Thread(web,"��ţ2").start();
		new Thread(web,"��ţ3").start();
	}
}

class UnsafeWeb12306 implements Runnable{
	//Ʊ��
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
		//ģ����ʾ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNumbers--);
	}

}