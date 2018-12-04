package com.learn.status;

/**
 * sleepģ��������ʱ���Ŵ��˷�������Ŀ�����
 * @author Administrator
 *
 */
public class BlockedSleep01 {
	public static void main(String[] args) {
		//һ����Դ
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"��ţ1").start();
		new Thread(web,"��ţ2").start();
		new Thread(web,"��ţ3").start();
	}
	
}

class Web12306 implements Runnable{
	//Ʊ��
	private int ticketNumbers=99;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(ticketNumbers<0){
				break;
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

}