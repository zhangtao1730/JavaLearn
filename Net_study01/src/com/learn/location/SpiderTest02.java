package com.learn.location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ���������ԭ�� + ģ�������
 * @author Administrator
 *
 */
public class SpiderTest02 {
	public static void main(String[] args) throws Exception {
		//��ȡURL
		URL url=new URL("https://www.dianping.com");
		//������Դ
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg=null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//����
		//����
	}
}
