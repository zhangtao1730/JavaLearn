package com.learn.thread;

/**
 * ��̬����
 * �����ӿڣ�
 * 1.���ǽ�ɫ
 * 2.�����ɫ
 * @author Administrator
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		//new Thread(�̶߳���).start();
	}
}

interface Marry{
	void happyMarry();
}
class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("you and XXX get married");
	}
	
}
//�����ɫ
class WeddingCompany implements Marry{
	//��ʵ��ɫ
	private Marry target;
	
	public WeddingCompany(Marry target) {
		this.target = target;
	}

	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
	}
	private void ready(){
		System.out.println("��������");
	}
	private void after(){
		System.out.println("�ֶ���");
	}
}