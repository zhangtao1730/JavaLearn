package com.learn.location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ���������ԭ��
 * @author Administrator
 *
 */
public class SpiderTest01 {
	public static void main(String[] args) throws Exception {
		//��ȡURL
		URL url=new URL("https://www.jd.com");
		//URL url=new URL("https://www.dianping.com");
		//������Դ
		InputStream is=url.openStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg=null;
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		br.close();
		//����
		//����
	}
}
