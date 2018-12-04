package com.learn.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ӰԺ
 * @author zhangtao
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		
		//����λ��
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
		new Thread(new HappyCustomer(c,seats1),"����").start();
		new Thread(new HappyCustomer(c,seats2),"����").start();
	}
}
//�˿�
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
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-->λ��Ϊ��"+seats);
			}else{
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-->λ�ò���");
			}
		}
	}
	
}
//ӰԺ
class HiCinema{
	List<Integer> available;//����λ��
	String name;
	public HiCinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//��Ʊ
	public boolean bookTickets(List<Integer> seats){
		System.out.println("��ӭѡ��"+this.name+",��ǰ����λ��Ϊ��"+available);
		List<Integer>copy=new ArrayList<>();
		copy.addAll(available);
		//���
		copy.removeAll(seats);
		//�жϴ�С
		if(available.size()-copy.size()!=seats.size()){
			return false;
		}
		//�ɹ�
		available=copy;
		return true;
	}
}