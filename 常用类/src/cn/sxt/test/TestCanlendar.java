package cn.sxt.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 测试日期类的使用
 * @author Administrator
 *
 */
public class TestCanlendar {
	public static void main(String[] args) {
		Calendar calendar=new GregorianCalendar(2999,10,9,22,10,50);
		int year=calendar.get(Calendar.YEAR);
		System.out.println(calendar);
		
		Calendar c2=new GregorianCalendar();
		c2.set(Calendar.YEAR, 8012);
		
		System.out.println(c2);
		
		Calendar c3=new GregorianCalendar();
		c3.add(Calendar.DATE, 100);
		System.out.println(c3);
	}
}
