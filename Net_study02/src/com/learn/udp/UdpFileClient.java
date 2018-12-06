package com.learn.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**�ļ�����
 * ���Ͷ�
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.����������ת��������
 * 3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author Administrator
 *
 */
public class UdpFileClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������...");
		//1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client=new DatagramSocket(8888);
		//2.׼������ һ��Ҫת���ֽ�����
		byte[] datas=IOUtils.fileToByteArray("people.jpg");

		//3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		//5.�ͷ���Դ
		client.close();
	}
}