package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * 
 * @author Administrator
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		Map<String,Object> row1=new HashMap<>();
		row1.put("id", 1001);
		row1.put("name", "张三");
		row1.put("salary", 20000);
		row1.put("入职日期", "2018.5.5");
		
		Map<String,Object> row2=new HashMap<>();
		row2.put("id", 1002);
		row2.put("name", "李四");
		row2.put("salary", 30000);
		row2.put("入职日期", "2005.4.4");
		
		
		Map<String,Object> row3=new HashMap<>();
		row3.put("id", 1003);
		row3.put("name", "王五");
		row3.put("salary", 3000);
		row3.put("入职日期", "2020.5.4");
		
		List<Map<String,Object>> table1=new ArrayList<>();
		table1.add(row1);
		table1.add(row2);
		table1.add(row3);
		for(Map<String,Object> row:table1){
			Set<String> keyset=row.keySet();
			for(String key:keyset){
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}
}
