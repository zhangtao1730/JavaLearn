package com.learn.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**��������
 * ���Ͷ�
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.����������ת��������
 * 3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author Administrator
 *
 */
public class UdObjClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������...");
		//1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client=new DatagramSocket(8888);
		//2.׼������ һ��Ҫת���ֽ�����
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		//������������
		oos.writeUTF("�첻�����ᣬ��ų���ҹ");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//����
		oos.writeObject("�ַ�������");
		oos.writeObject(new Date());
		Employee emp=new Employee("����",400);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas=baos.toByteArray();
		//3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		//5.�ͷ���Դ
		client.close();
	}
}
