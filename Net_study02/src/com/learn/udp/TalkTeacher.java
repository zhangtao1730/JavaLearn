package com.learn.udp;
/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * @author Administrator
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"С��Ů")).start();//����
		new Thread(new TalkSend(5555,"localhost",8888)).start();//����

	}
}
