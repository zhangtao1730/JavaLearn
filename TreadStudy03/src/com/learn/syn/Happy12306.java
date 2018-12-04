package com.learn.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ֻ�Ʊ
 * @author Administrator
 *
 */
public class Happy12306 {
	public static void main(String[] args) {
		Web12306 c=new Web12306(2,"CGV");
		new Passenger(c,"����",2).start();
		new Passenger(c,"����",2).start();

	}
}

//�˿�
class Passenger extends Thread{
	int seats;
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
}
//ӰԺ
class Web12306 implements Runnable{
	int available;//����λ��
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
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-->λ��Ϊ��"+p.seats);
		}else{
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-->λ�ò���");
		}
	}
	
	//��Ʊ
	public synchronized boolean bookTickets(int seats){
		System.out.println("����λ��Ϊ��"+available);
		if(seats>available){
			return false;
		}
		available-=seats;
		return true;
	}
}