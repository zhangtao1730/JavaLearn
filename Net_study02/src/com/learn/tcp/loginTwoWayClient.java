package com.learn.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ģ���½ ˫��
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Administrator
 *
 */
public class loginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------client---------------");
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String uname=console.readLine();
		System.out.println("���������룺");
		String upassword=console.readLine();
		//1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
		Socket client =new Socket("localhost",9999);
		//2.�������������������
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&upassword="+upassword);
		dos.flush();
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String result=dis.readUTF();
		System.out.println(result);
		
		//�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
	}
}
