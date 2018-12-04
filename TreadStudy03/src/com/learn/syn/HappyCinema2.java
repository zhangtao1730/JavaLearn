package com.learn.syn;
/**
 * 快乐影院
 * @author zhangtao
 *
 */
public class HappyCinema2 {
	public static void main(String[] args) {
		Cinema c=new Cinema(2,"CGV");
		new Thread(new Customer(c,2),"张三").start();
		new Thread(new Customer(c,1),"李四").start();
	}
}
//顾客
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	@Override
	public void run() {
		synchronized(cinema){
			// TODO Auto-generated method stub
			boolean flag=cinema.bookTickets(seats);
			if(flag){
				System.out.println("出票成功"+Thread.currentThread().getName()+"-->位置为："+seats);
			}else{
				System.out.println("出票失败"+Thread.currentThread().getName()+"-->位置不够");
			}
		}
	}
	
}
//影院
class Cinema{
	int available;//可用位置
	String name;
	public Cinema(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean bookTickets(int seats){
		System.out.println("可用位置为："+available);
		if(seats>available){
			return false;
		}
		available-=seats;
		return true;
	}
}