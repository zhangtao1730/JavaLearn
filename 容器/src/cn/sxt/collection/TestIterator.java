package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历List,Set,Map
 * @author Administrator
 *
 */
public class TestIterator {
	public static void main(String[] args) {
//		testIteratorList();
//		testIteratorSet();
		testIteratorMap();
	}
	public static void testIteratorList(){
		List<String> list=new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		//使用iterator遍历List
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String temp=iter.next();
			System.out.println(temp);
		}

	}
	public static void testIteratorSet(){
		Set<String> set=new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		//使用iterator遍历List
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String temp=iter.next();
			System.out.println(temp);
		}

	}
	public static void testIteratorMap(){
		Map<Integer,String> map1=new HashMap<>();
		map1.put(100, "aa");
		map1.put(200, "bb");
		map1.put(300, "cc");
		
		//第一种遍历Map的方式
		Set<Entry<Integer,String>> ss=map1.entrySet();
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp=iter.next();
			System.out.println(temp.getKey()+"---"+temp.getValue());
		}
		System.out.println("##############################");
		//第二种遍历Map的方式
		Set<Integer> keySet=map1.keySet();
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();){
			Integer key=iter.next();
			System.out.println(key+"---"+map1.get(key));
		}
		
	}
}
