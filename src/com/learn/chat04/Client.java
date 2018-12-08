package com.learn.chat04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺��������ʵ��Ⱥ��
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		System.out.println("�������û�����");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name =br.readLine();
		//1.��������
		Socket client=new Socket("localhost",8888);
		//2.�ͻ��˷�����Ϣ
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
