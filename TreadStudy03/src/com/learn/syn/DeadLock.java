package com.learn.syn;

/**
 * �����������ͬ����������໥���ͷ���Դ
 * �Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж���������
 * @author Administrator
 *
 * ���⣺��Ҫ��ͬһ��������в�Ҫͬʱ���ж���������
 */
public class DeadLock {
	public static void main(String[] args) {
		Makeup g1=new Makeup(1,"�Ű�֥");
		Makeup g2=new Makeup(0,"����");
		g1.start();
		g2.start();
	}
}
//�ں�
class Lipstick{
	
}
//����
class Mirror{
	
}
//��ױ
class Makeup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	//ѡ��
	int choice;
	//���� 
	String girl;
	public Makeup(int choice,String girl) {
		super();
		this.choice = choice;
		this.girl=girl;
	}
	@Override
	public void run() {
		//��ױ
		makeup();
	}
	//�໥���жԷ��Ķ�����-->�����������
	private void makeup(){
		if(choice==0){
			synchronized(lipstick){//��ÿں����
				System.out.println(this.girl + "Ϳ�ں�");
				//һ�����ӵ�о��ӵ���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				synchronized(mirror){
//					System.out.println(this.girl+"�վ���");
//				}
			}
			synchronized(mirror){
				System.out.println(this.girl+"�վ���");
			}
		}else{
			synchronized(mirror){//��þ��ӵ���
				System.out.println(this.girl + "�վ���");
				//һ�����ӵ�о��ӵ���
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				synchronized(lipstick){
//					System.out.println(this.girl+"Ϳ�ں�");
//				}
			}
			synchronized(lipstick){
				System.out.println(this.girl+"Ϳ�ں�");
			}
		}
	}
}