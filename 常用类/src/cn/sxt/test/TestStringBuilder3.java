package cn.sxt.test;
/**
 * ����StringBuilder,StringBuffer�ɱ��ַ�����
 * @author Administrator
 *
 */
public class TestStringBuilder3 {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<26;i++){
			char temp = (char)('a'+i);
			sb.append(temp);
		}
		System.out.println(sb);
		sb.reverse();//����
		System.out.println(sb);
		sb.setCharAt(3, '��');
		System.out.println(sb);
		sb.insert(0, '��').insert(6, '��');//��ʽ���á����ķ������÷���return��this
		System.out.println(sb);
		sb.delete(20, 23);
		System.out.println(sb);
	}
}
