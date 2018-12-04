package com.learn.cooperation;
/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽ�����źŵƷ�
 * @author Administrator
 * ������־λ
 */
public class CoTest02 {
	public static void main(String[] args) {
		Tv tv=new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}
//������ ��Ա
class Player extends Thread{
	Tv tv;
	public Player(Tv tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			if(i%2==0){
				this.tv.play("����˵");
			}else{
				this.tv.play("̫����");
			}
		}
	}
}
//������ ����
class Watcher extends Thread{
	Tv tv;
	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			tv.watch();
		}
	}
}
//ͬһ����Դ ����
class Tv{
	String voice;
	//�źŵ�
	//T ��ʾ��Ա���� ���ڵȴ�
	//F ��ʾ���ڹۿ� ��Ա�ȴ�
	boolean flag;
	//����
	public synchronized void play(String voice){
		//��Ա�ȴ�
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������"+voice);
		this.voice=voice;
		//����
		this.notifyAll();
		//�л���־
		this.flag=!this.flag;
	}
	//�ۿ�
	public synchronized void watch(){
		//���ڵȴ�
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������"+voice);
		//����
		this.notifyAll();
		//�л���־
		this.flag=!this.flag;
	}
	
}
