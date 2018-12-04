package com.learn.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度:Timer和TimerTask
 * @author Administrator
 *
 */
public class MyTimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//执行安排
		timer.schedule(new MyTask(), 1000);//执行任务一次
		//timer.schedule(new MyTask(), 1000,2000);//执行多次
//		Calendar cal=new GregorianCalendar(2099,12,31,32,53,54);
//		timer.schedule(new MyTask(), cal.getTime(),200);
	}
}
//任务类
class MyTask extends TimerTask{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("休息...");
		}
		System.out.println("------end-------");
	}
	
}