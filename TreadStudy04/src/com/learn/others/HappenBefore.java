package com.learn.others;
/**
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * @author Administrator
 *
 */
public class HappenBefore {
	//变量1
	private static int a=0;
	//变量2
	private static boolean flag =false;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++){
			a=0;
			flag=false;
		//线程1读取数据
		//线程1更改数据
		Thread t1=new Thread(()->{
			a=1;
			flag=true;
		});
		Thread t2=new Thread(()->{
			if(flag){
				a*=1;
//				System.out.println("happen before a-->"+a);
			}
			//指令重排
			if(a==0){
				System.out.println("happen before a-->"+a);
			}
		});
		t1.start();
		t2.start();
		//合并线程
		t1.join();
		t2.join();
		}
	}
}
