package com.learn.status;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * @author zhangtao
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			for(int i=0;i<5;i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("....");
			}
		});
		//观察状态
		State state=t.getState();
		System.out.println(state);//NEW
		
		t.start();
		state=t.getState();
		System.out.println(state);
//		while(state!=Thread.State.TERMINATED){
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			state=t.getState();
//			System.out.println(state);//TIMED_WAITING
//		}
		
		while(true){
			//活动的线程数
			int num=Thread.activeCount();
			System.out.println(num);
			if(num==1){
				break;
			}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state=t.getState();
		System.out.println(state);//TIMED_WAITING
	}
		
//		state=t.getState();
//		System.out.println(state);//TERMINATED
	}
}
