package cn.sxt.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * ����HashSet�Ļ����÷�
 * @author Administrator
 *
 */
public class TestSet {

	public static void main(String[] args) {
		Set<String> set1 =new HashSet<>();
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");
		System.out.println(set1);
		set1.remove("bb");
		System.out.println(set1);
 
	}
}
