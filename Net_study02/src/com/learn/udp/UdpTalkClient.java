package com.learn.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**��ν���
 * ���Ͷ�
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.׼������ һ��Ҫת���ֽ�����
 * 3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author Administrator
 *
 */
public class UdpTalkClient {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������...");
		//1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client=new DatagramSocket(8888);
		//2.׼������ һ��Ҫת���ֽ�����
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String data=reader.readLine();
			byte[] datas=data.getBytes();
			//3.��װ�� DatagramPacket ����,��Ҫ�ƶ�Ŀ�ĵ�
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
			//4.���Ͱ���send(DatagramPacket p)
			client.send(packet);
			if(datas.equals("bye")){
				break;
			}
		}
		//5.�ͷ���Դ
		client.close();
	}
}
