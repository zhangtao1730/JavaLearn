package com.learn.others;
/**
 * volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���
 * @author Administrator
 *
 */
public class VolatileTest {
	private volatile static int num=0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num==0){//�˴���Ҫ��д����
				
			}
		}).start();
		Thread.sleep(1000);
		num=1;
	}
}
