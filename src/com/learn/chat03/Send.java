package com.learn.chat03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ���Ͷ�
 * 1.������Ϣ
 * 2.�ӿ���̨��ȡ��Ϣ
 * 3.�ͷ���Դ
 * 4.��дrun
 * @author Administrator
 *
 */
public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	public Send(Socket client){
		isRunning=true;
		this.client=client;
		console=new BufferedReader(new InputStreamReader(System.in));
		try {
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("===1===");
			this.release();
		}

	}
	@Override
	public void run() {
		while(isRunning){
			String msg=getStrFromConsole();
			if(!msg.equals("")){
				send(msg);
			}
		}
	}

	//������Ϣ
	private void send(String msg){
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("===3===");
			release();
		}
	}
	/**
	 * �ӿ���̨��ȡ��Ϣ
	 * @return
	 */
	private String getStrFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	//�ͷ���Դ
	private void release(){
		this.isRunning=false;
		//�ͷ���Դ
		Utils.close(dos,client);
	}
}
