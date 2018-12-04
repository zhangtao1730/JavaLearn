package com.learn.others;
/**
 * ��������������������ʹ��+������
 * @author Administrator
 *
 */
public class LockTest03 {
	ReLock lock =new ReLock();
	public void a() throws InterruptedException{
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	//��������
	public void doSomething() throws InterruptedException{
		lock.lock();
		System.out.println(lock.getHoldCount());
		//.....
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest03 test=new LockTest03();
		test.a();
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
	}
}
//��������
class ReLock{
	//�Ƿ�ռ��
	private boolean isLocked=false;
	private Thread lockedBy=null;//�洢�߳�
	private int holdCount=0;
	//ʹ����
	public synchronized void lock() throws InterruptedException{
		System.out.println("��ʼʹ����");
		Thread t=Thread.currentThread();
		while(isLocked && lockedBy!=t){
			System.out.println("��ʼ�ȴ�");
			wait();
		}
		System.out.println("��ס--->������+1");
		isLocked=true;
		lockedBy=t;
		holdCount++;
	}
	public int getHoldCount() {
		return holdCount;
	}
	//�ͷ���
	public synchronized void unlock(){
		System.out.println("�ͷ���");
		if(Thread.currentThread()==lockedBy){
			holdCount--;
			if(holdCount==0){
				isLocked=false;
				notify();
				lockedBy=null;
			}
		}

	}
}