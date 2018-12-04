package com.learn.others;
/**
 * DCL����ģʽ������ʽ��·�����ϼ��벢�����ƣ���֤�ڶ��̻߳����£��������һ������
 * 1.������˽�л�-->�����ⲿnew������
 * 2.�ṩ˽�еľ�̬���� -->�洢����ĵ�ַ
 * 3.�ṩ�����ľ�̬���� -->��ȡ����
 * @author Administrator
 *
 */
public class DoubleCheckedLocking {
	//2.�ṩ˽�еľ�̬����
	//û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	private static volatile DoubleCheckedLocking instance;

	//1.������˽�л�
	private DoubleCheckedLocking(){
		
	}
	//3.�ṩ�����ľ�̬����
	public static DoubleCheckedLocking getInstance1(long time){
			if(instance==null){
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
				//1.���ٿռ� 2.��ʼ��������Ϣ 3.���ض���ĵ�ַ����
			}

		return instance;
	}
	//3.�ṩ�����ľ�̬����
	public static DoubleCheckedLocking getInstance(){
		//�ٴμ��
		if(instance!=null){
			return instance;
		}
		synchronized(DoubleCheckedLocking.class){
			if(instance==null){
				instance = new DoubleCheckedLocking();
				//1.���ٿռ� 2.��ʼ��������Ϣ 3.���ض���ĵ�ַ����
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			System.out.println(DoubleCheckedLocking.getInstance1(500));
		});
		t.start();
		System.out.println(DoubleCheckedLocking.getInstance1(1000));
	}
}
