package cn.sxt.test;
/**
 * �����Զ�װ�䣬�Զ�����
 * @author Administrator
 *
 */
public class TestAutoBox {
	public static void main(String[] args) {
		Integer a=234;//Integer a=Integer.valueOf(234);

		int b=a; 
		Integer c=null;
		if(c!=null){
			int d =c;
		}
		
		//����[-128,127]֮�������.ʵ�ʾ���ϵͳ��ʼ��ʱ�򴴽���[-128,127]֮���һ������
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        System.out.println(in1 == in2);//true ��Ϊ123�ڻ��淶Χ��
        System.out.println(in1.equals(in2));//true
        System.out.println("###############");
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//false ��Ϊ1234���ڻ��淶Χ��
        System.out.println(in3.equals(in4));//true
	}
}
