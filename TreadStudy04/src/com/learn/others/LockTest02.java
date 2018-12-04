package com.learn.others;
/**
 * ������������������������ʹ��
 * @author Administrator
 *
 */
public class LockTest02 {
	Lock lock =new Lock();
	public void a() throws InterruptedException{
		lock.lock();
		doSomething();
		lock.unlock();
	}
	//��������
	public void doSomething() throws InterruptedException{
		lock.lock();
		//.....
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest02 test=new LockTest02();
		test.a();
		test.doSomething();
	}
}
//����������
class Lock{
	//�Ƿ�ռ��
	private boolean isLocked=false;
	//ʹ����
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked=true;
	}
	//�ͷ���
	public synchronized void unlock(){
		isLocked=false;
		notify();
	}
}