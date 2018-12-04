package com.learn.status;

import javax.sound.midi.Soundbank;

/**
 * join:合并线程，插队线程
 * @author Administrator
 *
 */
public class BlockedJoin02 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("爸爸和儿子想抽烟的故事");
		new Thread(new Father()).start();
	}
}

class Father extends Thread{
	@Override
	public void run() {
		System.out.println("想抽烟。发现没了");
		System.out.println("让儿子去买烟");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();//father被阻塞
			System.out.println("老爸接过烟");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("孩子走丢了");
		}
	}
}
class Son extends Thread{
	@Override
	public void run() {
		System.out.println("结果老爸的钱...");
		System.out.println("路边有个游戏厅玩了10秒");
		for(int i=0;i<10;i++){
			System.out.println(i+"秒过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("赶紧买烟去");
		System.out.println("手拿一包中华回家");
	}
}