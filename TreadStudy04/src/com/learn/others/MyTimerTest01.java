package com.learn.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �������:Timer��TimerTask
 * @author Administrator
 *
 */
public class MyTimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//ִ�а���
		timer.schedule(new MyTask(), 1000);//ִ������һ��
		//timer.schedule(new MyTask(), 1000,2000);//ִ�ж��
//		Calendar cal=new GregorianCalendar(2099,12,31,32,53,54);
//		timer.schedule(new MyTask(), cal.getTime(),200);
	}
}
//������
class MyTask extends TimerTask{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("��Ϣ...");
		}
		System.out.println("------end-------");
	}
	
}