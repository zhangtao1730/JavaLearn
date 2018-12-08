package com.learn.chat03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺��װʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
 * @author Administrator
 *
 */
public class TMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		//1.��������
		Socket client=new Socket("localhost",8888);
		//2.�ͻ��˷�����Ϣ
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
	}
}
