package com.learn.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务端
 * 目标：实现一个客户可以正常收发信息
 * @author Administrator
 *
 */
public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server------");
		//1.指定端口
		ServerSocket server=new ServerSocket(8888);
		//2.阻塞式等待连接
		Socket client=server.accept();
		System.out.println("一个客户端建立了连接");
		
		//3.接收消息
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		//4.返回消息
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//释放资源
		dos.close();
		dis.close();
		client.close();
	}
}
