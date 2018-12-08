package com.learn.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң������
 * Ŀ�꣺ʵ��һ���ͻ����������շ���Ϣ
 * @author Administrator
 *
 */
public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.ָ���˿�
		ServerSocket server=new ServerSocket(8888);
		//2.����ʽ�ȴ�����
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽���������");
		
		//3.������Ϣ
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		//4.������Ϣ
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
	}
}
