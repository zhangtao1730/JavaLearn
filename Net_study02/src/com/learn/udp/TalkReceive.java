package com.learn.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 * @author Administrator
 *
 */
public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String from;
	public TalkReceive(int port,String from) {
		this.from=from;
		try {
			server=new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//2.准备容器 封装成 DatagramPacket 包裹
			byte[] container=new byte[1024*60];
			DatagramPacket packet =new DatagramPacket(container,0,container.length);
			 //3.阻塞式接收包裹receive(DatagramPacket p)
			try {
				server.receive(packet);//阻塞式
				 //4.分析数据
				 //	byte[] getData()
				 // 	   getLenth()
				byte[] datas=packet.getData();
				int len=packet.getLength();
				String data=new String(datas,0,len);
				System.out.println(from+":"+data);
				if(data.equals("bye")){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		server.close();
	}

}
