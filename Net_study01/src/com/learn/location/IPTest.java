package com.learn.location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点：计算机、路由、通讯设备等
 * InetAddress:多个静态方法
 * 1.getLocalHost：本机
 * 2.getByName:根据域名DNS|IP地址-->IP
 * 
 * 两个成员方法
 * 1.getHostAddress:返回地址
 * 2.getHostName:返回计算机名
 * @author Administrator
 *
 */
public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        //返回IP地址：192.168.1.110
        System.out.println(addr.getHostAddress()); 
        //输出计算机名：
        System.out.println(addr.getHostName()); 
	
        addr = InetAddress.getByName("www.google.com");
        // 返回 google服务器的IP:59.110.14.7
        System.out.println(addr.getHostAddress());
        // 输出：www.google.cn
        System.out.println(addr.getHostName());
        
        addr = InetAddress.getByName("59.110.14.7");
        // 返回sxt服务器的IP：59.110.14.7
        System.out.println(addr.getHostAddress());
        /*
         * 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。
         */
        System.out.println(addr.getHostName());
	}

}
