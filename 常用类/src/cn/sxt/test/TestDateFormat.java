package cn.sxt.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�������ַ���֮��Ļ���ת��
 * @author Administrator
 *
 */
public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str =  df.format(new Date());
		System.out.println(str);
	}
}
