package com.learn.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���½ ˫��
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author Administrator
 *
 */
public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------------server---------------");
		//1.ָ���˿� ʹ��ServerSocket����������
		ServerSocket server =new ServerSocket(9999);
		//2.����ʽ�ȴ����� accept
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽���������");
		//3.�������������������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String datas=dis.readUTF();
		String uname="";
		String upassword="";
		//��������
		String[] dataArray=datas.split("&");
		for(String info:dataArray){
			String[] userInfo=info.split("=");
			System.out.println(userInfo[0]+"-->"+userInfo[1]);
			if(userInfo[0].equals("uname")){
				System.out.println("����û���Ϊ��"+userInfo[1]);
				uname=userInfo[1];
			}else if(userInfo[0].equals("upassword")){
				System.out.println("�������Ϊ��"+userInfo[1]);
				upassword=userInfo[1];
			}
		}
		//���
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(uname.equals("zhangtao")&&upassword.equals("zhang123")){//�ɹ�
			dos.writeUTF("��½�ɹ�");
		}else{//ʧ��
			dos.writeUTF("�û������������");
		}
		dos.flush();
		//4.�ͷ���Դ
		dis.close();
		dos.close();
		client.close();
	}
}
