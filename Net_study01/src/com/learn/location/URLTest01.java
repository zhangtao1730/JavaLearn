package com.learn.location;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL:ͳһ��Դ��λ�� �����������ʯ֮һ(html http),������Դ
 * 1.Э��
 * 2.�����������
 * 3.�˿ڣ�Ĭ��80
 * 4.������Դ
 * http://www.baidu.com:80/index.html?uname=zhangtao&age=18#a
 * @author Administrator
 *
 */
public class URLTest01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.baidu.com:80/index.html?uname=zhangtao&age=18#a");
		//��ȡ�ĸ�ֵ
		System.out.println("Э��:"+url.getProtocol());
		System.out.println("����|ip:"+url.getHost());
		System.out.println("�˿�:"+url.getPort());
		System.out.println("������Դ1:"+url.getFile());
		System.out.println("������Դ2:"+url.getPath());
		//����
		System.out.println("������"+url.getQuery());
		//ê��
		System.out.println("ê�㣺"+url.getRef());
	}
}
