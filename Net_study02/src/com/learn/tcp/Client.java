package com.learn.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------client---------------");
		//1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
		Socket client =new Socket("localhost",9999);
		//2.�������������������
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		String data="hello";
		dos.writeUTF(data);
		dos.flush();
		//�ͷ���Դ
		dos.close();
		client.close();
	}
}
