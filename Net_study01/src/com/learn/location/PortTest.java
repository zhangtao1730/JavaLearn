package com.learn.location;

import java.net.InetSocketAddress;

/**
 * �˿�
 * 1.�������
 * 2.2���ֽ� 0-65535 UDP TCp
 * 3.ͬһ��Э��˿ڲ��ܳ�ͻ
 * 4.����˿�Խ��Խ��
 * InetSocketAddress
 * 1.������
 * 	new InetSocketAddress(��ַ|����,�˿�)
 * 2.����
 *  getAddress()
 *  getPort()
 *  getHostName()
 * @author Administrator
 *
 */
public class PortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress.getPort());
	}

}
