package com.learn.others;
/**
 * ��������������������ʹ��
 * @author Administrator
 *
 */
public class LockTest01 {
	public void test(){
		//��һ�λ����
		synchronized(this){
			while(true){
				//�ڶ��λ��ͬ������
				synchronized(this){
					System.out.println("ReentrantLock");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new LockTest01().test();
	}
}
