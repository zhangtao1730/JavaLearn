package cn.sxt.oop;
/**
 * �����ַ����ĳ��÷���
 * @author Administrator
 *
 */
public class TestString2 {
	public static void main(String[] args) {
		
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//��ȡ�±�Ϊ3���ַ�
        System.out.println(s2.length());//�ַ����ĳ���
        System.out.println(s1.equals(s2));//�Ƚ������ַ����Ƿ����
        System.out.println(s1.equalsIgnoreCase(s2));//�Ƚ������ַ��������Դ�Сд��
        System.out.println(s1.indexOf("Java"));//�ַ���s1���Ƿ����Java
        System.out.println(s1.indexOf("apple"));//�ַ���s1���Ƿ����apple
        String s = s1.replace(' ', '&');//��s1�еĿո��滻��&
        System.out.println("result is :" + s);
		
	}
}
