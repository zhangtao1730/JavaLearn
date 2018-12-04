package cn.sxt.test;
/**
 * 测试StringBuilder,StringBuffer可变字符序列
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
		sb.reverse();//倒序
		System.out.println(sb);
		sb.setCharAt(3, '张');
		System.out.println(sb);
		sb.insert(0, '我').insert(6, '爱');//链式调用。核心方法：该方法return了this
		System.out.println(sb);
		sb.delete(20, 23);
		System.out.println(sb);
	}
}
