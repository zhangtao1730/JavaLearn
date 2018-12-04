package com.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CDownloader implements Callable {
	private String url;//远程路径
	private String name;//存储名字
	public CDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}
	@Override
	public Boolean call() throws Exception{
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1=new CDownloader("http://tp.yiaedu.com/showimg.php?url=http://uploads.xuexila.com/allimg/1703/867-1F330164643.jpg","sky.jpg");
		CDownloader cd2=new CDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2230167403,4188800858&fm=26&gp=0.jpg","sea.jpg");
		CDownloader cd3=new CDownloader("http://tupian.qqjay.com/u/2017/1201/2_161641_2.jpg","people.jpg");
		
		//创建执行服务
		ExecutorService ser=Executors.newFixedThreadPool(3);
		//提交执行：
		Future<Boolean> result1=ser.submit(cd1);
		Future<Boolean> result2=ser.submit(cd2);
		Future<Boolean> result3=ser.submit(cd3);
		
		//获取结果：
		boolean r1=result1.get();
		boolean r2=result2.get();
		boolean r3=result3.get();
		System.out.println(r3);
		//释放资源、关闭服务
		ser.shutdown();
	}
}

