package com.learn.cooperation;
/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽһ���̷ܳ�
 * @author Administrator
 * ����������
 */
public class CoTest01 {
	public static void main(String[] args) {
		SynContainer container =new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
		
	}
}
//������
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}
	public void run() {
		//����
		for(int i=0;i<100;i++){
			System.out.println("����-->"+i+"����ͷ");
			container.push(new Steamedbun(i));
		}
	}
}
//������
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	public void run() {
		//����
		for(int i=0;i<100;i++){
			System.out.println("����-->"+container.pop().id+"����ͷ");
		}
	}
}
//������
class SynContainer{
	Steamedbun[] buns=new Steamedbun[10];
	int count=0;//������
	//�洢 ����
	public synchronized void push(Steamedbun bun){
		//��ʱ���� �������ڿռ�
		//�������� ֻ�еȴ�
		if(count==buns.length){
			try {
				this.wait();//�߳����� ������֪ͨ�������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//���ڿռ� ��������
		buns[count]=bun;
		count++;
		//�������ݣ�����֪ͨ����
		this.notifyAll();
	}
	//��ȡ ����
	public synchronized Steamedbun pop(){
		//��ʱ���� �������Ƿ��������
		//û������ ֻ�еȴ�
		if(count==0){
			try {
				this.wait();//�߳����� ������֪ͨ���ѽ������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�������ݿ�������
		count--;
		Steamedbun bun=buns[count];
		this.notifyAll();//���ڿռ�,���Ի��ѶԷ�����
		return bun;
	}
}
//���ݣ���ͷ��
class Steamedbun{
	int id;

	public Steamedbun(int id) {
		super();
		this.id = id;
	}
}