package cn.sxt.test;


/**
 * ���԰�װ��
 * @author Administrator
 *
 */
public class TestWrappedClass {
	public static void main(String[] args) {
		//������������ת�ɰ�װ�����
		Integer a =new Integer(3);
		Integer b = Integer.valueOf(30);
		//�Ѱ�װ�����ת�ɻ�����������
		int c = b.intValue();
		double d=b.doubleValue();
		//���ַ���ת�ɰ�װ�����
		Integer e=new Integer("9999");
		Integer f=Integer.parseInt("998");
		//�Ѱ�װ�����ת���ַ���
		String str=f.toString();
		//�����ĳ���
		System.out.println("int��������������"+Integer.MAX_VALUE);
	}
}
