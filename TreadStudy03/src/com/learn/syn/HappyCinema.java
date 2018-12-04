package com.learn.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 * @author zhangtao
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		
		//可用位置
		List<Integer> available=new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		
		List<Integer> seats1=new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2=new ArrayList<>();
		seats2.add(1);
		seats2.add(2);
		seats2.add(6);
		HiCinema c=new HiCinema(available,"CGV");
		new Thread(new HappyCustomer(c,seats1),"张三").start();
		new Thread(new HappyCustomer(c,seats2),"李四").start();
	}
}
//顾客
class HappyCustomer implements Runnable{
	HiCinema cinema;
	List<Integer> seats;
	public HappyCustomer(HiCinema cinema, List<Integer> seats) {
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
class HiCinema{
	List<Integer> available;//可用位置
	String name;
	public HiCinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean bookTickets(List<Integer> seats){
		System.out.println("欢迎选购"+this.name+",当前可用位置为："+available);
		List<Integer>copy=new ArrayList<>();
		copy.addAll(available);
		//相减
		copy.removeAll(seats);
		//判断大小
		if(available.size()-copy.size()!=seats.size()){
			return false;
		}
		//成功
		available=copy;
		return true;
	}
}