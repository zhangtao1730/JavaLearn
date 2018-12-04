package com.learn.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**�������ͣ�
 //���ն�
 //1.ʹ��DatagramSocket ָ���˿� �������ն�
 //2.׼������ ��װ�� DatagramPacket ����
 //3.����ʽ���հ���receive(DatagramPacket p)
 //4.�������� ���ֽ����黹ԭΪ��Ӧ������
 //	byte[] getData()
 // 	   getLenth()
 //5.�ͷ���Դ
 //@author Administrator
 *
 */
public class UdpObjServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������...");
		 //1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server=new DatagramSocket(9999);
		 //2.׼������ ��װ�� DatagramPacket ����
		byte[] container=new byte[1024*60];
		DatagramPacket packet =new DatagramPacket(container,0,container.length);
		 //3.����ʽ���հ���receive(DatagramPacket p)
		server.receive(packet);//����ʽ
		 //4.��������
		 //	byte[] getData()
		 // 	   getLenth()
		byte[] datas=packet.getData();
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//˳����д��һ��
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
		 //5.�ͷ���Դ
		server.close();
	}
}