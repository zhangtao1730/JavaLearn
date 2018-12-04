package com.learn.thread;

public class IDownloader implements Runnable {
	private String url;//远程路径
	private String name;//存储名字
	public IDownloader(String url, String name) {
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
		IDownloader td1=new IDownloader("http://tp.yiaedu.com/showimg.php?url=http://uploads.xuexila.com/allimg/1703/867-1F330164643.jpg","sky.jpg");
		IDownloader td2=new IDownloader("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2230167403,4188800858&fm=26&gp=0.jpg","sea.jpg");
		IDownloader td3=new IDownloader("http://tupian.qqjay.com/u/2017/1201/2_161641_2.jpg","people.jpg");
		
		//启动三个线程
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}

