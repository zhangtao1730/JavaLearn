package com.learn.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ϴ��ļ�
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Administrator
 *
 */
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------client---------------");
		//1.�������ӣ�ʹ��Socket�����ͻ��� +��������ַ�Ͷ˿�
		Socket client =new Socket("localhost",8888);
		//2.�����������ϴ�
		InputStream is=new BufferedInputStream(new FileInputStream("people.png"));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1){
			os.write(flush,0,len);
		}
		os.flush();
		//�ͷ���Դ
		os.close();
		is.close();
		client.close();
	}
}
