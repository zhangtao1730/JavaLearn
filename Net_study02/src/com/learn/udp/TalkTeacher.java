package com.learn.udp;
/**
 * 加入多线程，实现双向交流 模拟在现咨询
 * @author Administrator
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"小仙女")).start();//接收
		new Thread(new TalkSend(5555,"localhost",8888)).start();//发送

	}
}
