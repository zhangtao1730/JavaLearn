package cn.sxt.array2;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * ��������Ŀ���
 * @author Administrator
 *
 */
public class TestArrayCopy {
	public static void main(String[] args) {
//		testBasicCopy2();
		
		String[] str={"����","����","��ѧ��","�ٶ�","����ѷ"};
//		removeElment(str, 1);
		str = extendRange(str);
	}
	public static void testBasicCopy(){
		String[] s1={"aa","bb","cc","dd","ee"};
		String[] s2=new String[10];
		System.arraycopy(s1, 2, s2, 6, 3);
		
		for(int i=0;i<s2.length;i++){
			System.out.println(i+"---"+s2[i]);
		}
	}
	
	//���Դ�������ɾ��ĳ��Ԫ��(�����ϻ�������Ŀ���)
	public static void testBasicCopy2(){
		String[] s1={"aa","bb","cc","dd","ee"};
//		String[] s2=new String[5];
		
		System.arraycopy(s1, 3, s1, 3-1, s1.length-3);
		s1[s1.length-1]=null;
		for(int i=0;i<s1.length;i++){
			System.out.println(i+"---"+s1[i]);
		}
	}
	
	//ɾ���������ƶ�����λ�õ�Ԫ�أ�����ԭ���鷵��
	public static String[] removeElment(String[] s,int index){
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length-1]=null;
		for(int i=0;i<s.length;i++){
			System.out.println(i+"---"+s[i]);
		}
		return s;
	}
	//��������ݣ��������ǣ��ȶ���һ����������飬Ȼ��ԭ��������ԭ�ⲻ���������������У�
	public static String[] extendRange(String[] s1){
		String[] s2=new String[s1.length+10];
		
		System.arraycopy(s1, 0, s2, 0, s1.length);
		for(String s:s2){
			System.out.println(s);
		}
		return s2;
	}
}
