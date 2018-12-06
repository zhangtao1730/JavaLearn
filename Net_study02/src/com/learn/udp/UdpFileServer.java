package com.learn.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**�ļ����ͣ�
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
public class UdpFileServer {
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
		IOUtils.byteArrayToFile(datas, "src/copy.jpg");
		//5.�ͷ���Դ
		server.close();
	}
}