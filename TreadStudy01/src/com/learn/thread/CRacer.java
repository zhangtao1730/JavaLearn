package com.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
 * @author zhangtao
 *
 */
public class CRacer implements Callable<Integer>{
	//胜利者
	private static String winner;
	@Override
	public Integer call() throws Exception{
		for(int steps=1;steps<=100;steps++){
			//模拟休息
			if("pool-1-thread-1".equals(Thread.currentThread().getName())&&steps%10==0){
				Thread.sleep(100);
			}
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag = gameOver(steps);
			if(flag){
				return steps;
			}
		}
		return null;
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
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer racer=new CRacer();
		//创建执行服务
		ExecutorService ser=Executors.newFixedThreadPool(2);
		//提交执行：
		Future<Integer> result1=ser.submit(racer);
		Future<Integer> result2=ser.submit(racer);
		//获取结果：
		Integer r1=result1.get();
		Integer r2=result2.get();
		System.out.println(r1+"--->"+r2);
		//释放资源、关闭服务
		ser.shutdown();
	}
}
