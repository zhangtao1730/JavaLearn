package com.learn.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:�Ƚϲ�����
 * @author Administrator
 *
 */
public class CAS {
	//���
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(()->{
				//ģ���ӳ�
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<1){
					System.out.println("������...");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"����һ����Ʒ-->��ʣ"+left);
			}).start();
		}
	}
}
