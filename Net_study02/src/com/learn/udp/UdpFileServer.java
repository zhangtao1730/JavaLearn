package com.learn.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**文件类型：
 //接收端
 //1.使用DatagramSocket 指定端口 创建接收端
 //2.准备容器 封装成 DatagramPacket 包裹
 //3.阻塞式接收包裹receive(DatagramPacket p)
 //4.分析数据 将字节数组还原为对应的类型
 //	byte[] getData()
 // 	   getLenth()
 //5.释放资源
 //@author Administrator
 *
 */
public class UdpFileServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中...");
		 //1.使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(9999);
		 //2.准备容器 封装成 DatagramPacket 包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet =new DatagramPacket(container,0,container.length);
		 //3.阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);//阻塞式
		 //4.分析数据
		 //	byte[] getData()
		 // 	   getLenth()
		byte[] datas=packet.getData();
		IOUtils.byteArrayToFile(datas, "src/copy.jpg");
		//5.释放资源
		server.close();
	}
}