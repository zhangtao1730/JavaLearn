package cn.sxt.oop;

/**
 * �����ַ�����Ļ����÷�
 * @author Administrator
 *
 */
public class TestString {
	public static void main(String[] args) {
		String str="abc";
		String str2=new String("def");
		String str3="abc"+"def";
		String str4="18"+19;
		System.out.println(str4);

		System.out.println("################");
		String str10="zhang";
		String str11="zhang";
		String str12=new String("zhang");
		
		System.out.println(str10==str11);
		System.out.println(str12==str11);//str11��str12����ͬһ������
		//ͨ���Ƚ��ַ���ʱ��ʹ��equals
		System.out.println(str12.equals(str11));
		
	}

}
