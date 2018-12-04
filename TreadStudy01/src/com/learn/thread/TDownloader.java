package com.learn.thread;

public class TDownloader extends Thread {
	private String url;//远程路径
	private String name;//存储名字
	public TDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}
	@Override
	public void run() {
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	public static void main(String[] args) {
		TDownloader td1=new TDownloader("http://tp.yiaedu.com/showimg.php?url=http://uploads.xuexila.com/allimg/1703/867-1F330164643.jpg","sky.jpg");
		TDownloader td2=new TDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2230167403,4188800858&fm=26&gp=0.jpg","sea.jpg");
		TDownloader td3=new TDownloader("http://tupian.qqjay.com/u/2017/1201/2_161641_2.jpg","people.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}

