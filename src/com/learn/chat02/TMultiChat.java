package com.learn.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң������
 * Ŀ�꣺ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
 * ���⣺
 * 1.���벻��ά��
 * 2.�ͻ��˶�дû�зֿ� ������д���
 * @author Administrator
 *
 */
public class TMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.ָ���˿�
		ServerSocket server=new ServerSocket(8888);
		//2.����ʽ�ȴ�����
		while(true){
			Socket client=server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(()->{
				DataInputStream dis=null;
				DataOutputStream dos=null;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos=new DataOutputStream(client.getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean isRunning=true;
				while(isRunning){
					//3.������Ϣ
					String msg;
					try {
						msg = dis.readUTF();
						//4.������Ϣ
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						isRunning=false;//����ֹͣ�߳�
					}
				}
				//�ͷ���Դ
				try {
					if(null!=dos){
						dos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(null!=dis){
						dis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(null!=client){
						client.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();

		}
	}
}
