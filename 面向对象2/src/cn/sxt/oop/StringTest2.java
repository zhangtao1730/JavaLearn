package cn.sxt.oop;
public class StringTest2 {
    public static void main(String[] args) {
        String s = "";
        String s1 = "How are you?";
        System.out.println(s1.startsWith("How"));//�Ƿ���How��ͷ
        System.out.println(s1.endsWith("you"));//�Ƿ���you��β
        s = s1.substring(4);//��ȡ���ַ��������±�Ϊ4�Ŀ�ʼ���ַ�����βΪֹ
        System.out.println(s);
        s = s1.substring(4, 7);//��ȡ���ַ������±�[4, 7) ������7
        System.out.println(s);
        s = s1.toLowerCase();//תСд
        System.out.println(s);
        s = s1.toUpperCase();//ת��д
        System.out.println(s);
        String s2 = "  How old are you!! ";
        s = s2.trim();//ȥ���ַ�����β�Ŀո�ע�⣺�м�Ŀո���ȥ��
        System.out.println(s);
        System.out.println(s2);//��ΪString�ǲ��ɱ��ַ���������s2����
    }
}