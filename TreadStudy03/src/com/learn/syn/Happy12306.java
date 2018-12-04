package com.learn.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐火车票
 * @author Administrator
 *
 */
public class Happy12306 {
	public static void main(String[] args) {
		Web12306 c=new Web12306(2,"CGV");
		new Passenger(c,"张三",2).start();
		new Passenger(c,"李四",2).start();

	}
}

//顾客
class Passenger extends Thread{
	int seats;
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
}
//影院
class Web12306 implements Runnable{
	int available;//可用位置
	String name;
	public Web12306(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	@Override
	public void run() {
		Passenger p = (Passenger)Thread.currentThread();
		// TODO Auto-generated method stub
		boolean flag=this.bookTickets(p.seats);
		if(flag){
			System.out.println("出票成功"+Thread.currentThread().getName()+"-->位置为："+p.seats);
		}else{
			System.out.println("出票失败"+Thread.currentThread().getName()+"-->位置不够");
		}
	}
	
	//购票
	public synchronized boolean bookTickets(int seats){
		System.out.println("可用位置为："+available);
		if(seats>available){
			return false;
		}
		available-=seats;
		return true;
	}
}