package com.learn.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���½ ����ͻ�������
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author Administrator
 *
 */
public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------------server---------------");
		//1.ָ���˿� ʹ��ServerSocket����������
		ServerSocket server =new ServerSocket(9999);
		boolean isRunning=true;
		//2.����ʽ�ȴ����� accept
		System.out.println("һ���ͻ��˽���������");
		while(isRunning){
			Socket client=server.accept();
			new Thread(new Channel(client)).start();
		}
		server.close();
	}
	//һ��Channel����һ���ͻ�������
	static class Channel implements Runnable{
		private Socket client;
		//������
		private DataInputStream dis;
		//�����
		private DataOutputStream dos;
		public Channel(Socket client){
			this.client=client;
			try {
				//����
				dis = new DataInputStream(client.getInputStream());
				//���
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}
		
		//��������
		private String receive(){
			String datas="";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return datas;
		}
		//�ͷ���Դ
		private void release(){
			//4.�ͷ���Դ
			try {
				if(dis!=null){
					dis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(dos!=null){
					dos.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(client!=null){
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��������
		private void send(String msg){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			//3.�������������������
			
			String uname="";
			String upassword="";
			//��������
			String[] dataArray=receive().split("&");
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
			if(uname.equals("zhangtao")&&upassword.equals("zhang123")){//�ɹ�
				send("��½�ɹ�");
			}else{//ʧ��
				send("�û������������");
			}
			release();
		}
	}

}
