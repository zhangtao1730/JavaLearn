package com.learn.thread;

/**
 * �����̷߳�ʽһ��
 * 1.�������̳�Thread+��дrun
 * 2.�����������������+start
 * @author zhangtao
 *
 */
public class StartThread extends Thread{
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
		//�����������
		StartThread st=new StartThread();
		//����
		st.start();//����֤�������� cpu����
//		st.run();//��ͨ�����ĵ���
		for(int i=0;i<20;i++){
			System.out.println("һ��coding");
		}
	}
}
