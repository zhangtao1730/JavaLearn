package cn.sxt.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的互相转换
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
