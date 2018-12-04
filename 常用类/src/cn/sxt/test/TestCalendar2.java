package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ���������
 * @author Administrator
 *
 */
public class TestCalendar2 {
	public static void main(String[] args) throws ParseException {
		System.out.println("����������(��ʽ��2010-9-10)");
		Scanner scanner=new Scanner(System.in);

		String str=scanner.nextLine();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar c=new GregorianCalendar();
		c.setTime(date);
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		int day=c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, 1);
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++){
			System.out.print("\t");
		}

		int days=c.getActualMaximum(Calendar.DATE);
		for(int i=1;i<=days;i++){
			
			if(day==c.get(Calendar.DAY_OF_MONTH)){
				System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
			}else{
				System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
			}
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
				System.out.println();
			}

			c.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
