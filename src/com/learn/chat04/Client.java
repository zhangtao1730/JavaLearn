package com.learn.chat04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：加入容器实现群聊
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client------");
		System.out.println("请输入用户名：");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name =br.readLine();
		//1.建立连接
		Socket client=new Socket("localhost",8888);
		//2.客户端发送消息
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
