package com.learn.status;

/**
 * ��ֹ�߳�
 * 1.�߳�����ִ�����-->����
 * 2.�ⲿ����-->�����ʶ
 * ��Ҫʹ��stop destroy
 * @author Administrator
 *
 */
public class TerminateThread implements Runnable{
	//1.�����ʶ ����߳����Ƿ��������
	private boolean flag=true;
	private String name;

	@Override
	public void run() {
		int i=0;
		//2.������ʶ true-->���� false-->ֹͣ
		while(flag){
			System.out.println(name+"-->"+i++);
		}
	}
	public TerminateThread(String name) {
		this.name = name;
	}
	//3.�����ṩ�����ı��ʶ
	public void terminate(){
		this.flag=false;
	}
	
	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread("C��");
		new Thread(tt).start();
		for(int i=0;i<100;i++){
			if(i==88){
				tt.terminate();//�̵߳���ֹ
				System.out.println("game over");
			}
			System.out.println("main-->"+i);
		}
	}
}
