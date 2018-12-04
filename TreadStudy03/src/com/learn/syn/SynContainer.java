package com.learn.syn;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

/**
 * 线程不安全：操作并发容器
 * @author Administrator
 *
 */
public class SynContainer {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
		for(int i=0;i<10000;i++){
			new Thread(()->{
					list.add(Thread.currentThread().getName());
			}).start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}
