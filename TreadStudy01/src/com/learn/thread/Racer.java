package com.learn.thread;

/**
 * 模拟龟兔赛跑
 * @author zhangtao
 *
 */
public class Racer implements Runnable{
	//胜利者
	private static String winner;
	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++){
			//模拟休息
			if("rabbit".equals(Thread.currentThread().getName())&&steps%10==0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag = gameOver(steps);
			if(flag){
				break;
			}
		}
		
	}
	private boolean gameOver(int steps){
		if(winner!=null){
			return true;
		}else{
			if(steps==100){
				winner=Thread.currentThread().getName();
				System.out.println("winner-->"+winner);
				return true;
			}else{
				return false;
			}
		}
	}
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
