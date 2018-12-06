package com.learn.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登陆 双向
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端 +服务器地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author Administrator
 *
 */
public class loginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------client---------------");
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String uname=console.readLine();
		System.out.println("请输入密码：");
		String upassword=console.readLine();
		//1.建立连接：使用Socket创建客户端 +服务器地址和端口
		Socket client =new Socket("localhost",9999);
		//2.操作：输入输出流操作
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&upassword="+upassword);
		dos.flush();
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String result=dis.readUTF();
		System.out.println(result);
		
		//释放资源
		dos.close();
		dis.close();
		client.close();
	}
}
