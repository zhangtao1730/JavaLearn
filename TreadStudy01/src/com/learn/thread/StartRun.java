package com.learn.thread;

/**
 * �����̷߳�ʽ����
 * 1.������ʵ��Runnable+��дrun
 * 2.����������ʵ�������+Thread����+start()
 * 
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * @author zhangtao
 *
 */
public class StartRun implements Runnable{
	/**
	 * �߳���ڵ�
	 */
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			System.out.println("һ������");
		}
	}
	public static void main(String[] args) {
//		//����ʵ�������
//		StartRun sr=new StartRun();
//		//�������������
//		Thread t=new Thread(sr);
//		//����
//		t.start();//����֤�������� cpu����
		
		new Thread(new StartRun()).start();
//		st.run();//��ͨ�����ĵ���
		for(int i=0;i<20;i++){
			System.out.println("һ��coding");
		}
	}
}
