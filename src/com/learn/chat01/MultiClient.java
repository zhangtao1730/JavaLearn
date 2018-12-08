package com.learn.chat01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺ʵ��һ���ͻ����������շ�������Ϣ
 * @author Administrator
 *
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		//1.��������
		Socket client=new Socket("localhost",8888);
		//2.�ͻ��˷�����Ϣ
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		DataInputStream dis=new DataInputStream(client.getInputStream());

		boolean isRunning=true;
		while(isRunning){
			String msg=console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			
			//3.��ȡ��Ϣ
			msg=dis.readUTF();
			System.out.println(msg);
		}
		
		dos.close();
		dis.close();
		client.close();
		
	}
}
