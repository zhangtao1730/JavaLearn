package com.learn.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**引用类型：
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
public class UdpObjServer {
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
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一致
		String msg=ois.readUTF();
		int age=ois.readInt();
		boolean flag=ois.readBoolean();
		char ch=ois.readChar(); 
		System.out.println(flag);
		Object str=ois.readObject();
		Object date =ois.readObject();
		Object employee=ois.readObject();
		
		if(str instanceof String){
			String strObj=(String) str;
			System.out.println(strObj);
		}
		if(date instanceof Date){
			Date dateObj=(Date)date;
			System.out.println(dateObj);
		}
		if(employee instanceof Employee){
			Employee employeeObj=(Employee)employee;
			System.out.println(employeeObj.getName()+"--->"+employeeObj.getSalary());
		}
		
		
		
		System.out.println(msg+"-->"+age+"-->"+flag);
		 //5.释放资源
		server.close();
	}
}