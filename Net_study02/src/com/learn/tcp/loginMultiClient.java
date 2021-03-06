package com.learn.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登陆 多个客户端请求
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端 +服务器地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author Administrator
 *
 */
public class loginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------client---------------");
		//1.建立连接：使用Socket创建客户端 +服务器地址和端口
		Socket client =new Socket("localhost",9999);
		//2.操作：输入输出流操作 先请求后响应
		new Send(client).send();
		new Receive(client).receive();
		client.close();
	}
	//发送
	static class Send{
		private DataOutputStream dos;
		private Socket client;
		private BufferedReader console;
		private String msg;
		public Send(Socket client){
			this.client=client;
			console=new BufferedReader(new InputStreamReader(System.in));
			msg=init();
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		private String init(){
			try {
				System.out.println("请输入用户名：");
				String uname=console.readLine();
				System.out.println("请输入密码：");
				String upassword=console.readLine();
				return "uname="+uname+"&upassword="+upassword;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		public void send(){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//接收
	static class Receive{
		private DataInputStream dis;
		private Socket client;
		public Receive(Socket client){
			this.client=client;
			try {
				dis=new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void receive(){
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
