package com.learn.location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:��λһ���ڵ㣺�������·�ɡ�ͨѶ�豸��
 * InetAddress:�����̬����
 * 1.getLocalHost������
 * 2.getByName:��������DNS|IP��ַ-->IP
 * 
 * ������Ա����
 * 1.getHostAddress:���ص�ַ
 * 2.getHostName:���ؼ������
 * @author Administrator
 *
 */
public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        //����IP��ַ��192.168.1.110
        System.out.println(addr.getHostAddress()); 
        //������������
        System.out.println(addr.getHostName()); 
	
        addr = InetAddress.getByName("www.google.com");
        // ���� google��������IP:59.110.14.7
        System.out.println(addr.getHostAddress());
        // �����www.google.cn
        System.out.println(addr.getHostName());
        
        addr = InetAddress.getByName("59.110.14.7");
        // ����sxt��������IP��59.110.14.7
        System.out.println(addr.getHostAddress());
        /*
         * ���ip������������������IP��ַ�����ڻ�DNS���������������IP��ַ
         * ��������ӳ�䣬getHostName������ֱ�ӷ������IP��ַ��
         */
        System.out.println(addr.getHostName());
	}

}
