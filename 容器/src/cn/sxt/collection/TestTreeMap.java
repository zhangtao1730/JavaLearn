package cn.sxt.collection;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer,String> treemap1=new TreeMap<>();
		treemap1.put(20,"aa");
		treemap1.put(3,"bb");
		treemap1.put(6,"cc");
		//按照key递增的方式排序；
		for(Integer key:treemap1.keySet()){
			System.out.println(key+"---"+treemap1.get(key));
		}
		
		Map<Emp,String> treemap2=new TreeMap<>();
		treemap2.put(new Emp(100,"张三",50000), "aaa");
		treemap2.put(new Emp(200,"李四",5000), "bbb");
		treemap2.put(new Emp(150,"王五",6000), "ccc");
		treemap2.put(new Emp(50,"赵六",6000), "ddd");
		
		//按照key递增的方式排序；
		for(Emp key:treemap2.keySet()){
			System.out.println(key.toString()+"---"+treemap2.get(key));
		}
	}
}

class Emp implements Comparable<Emp>{
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	int id;
	String name;
	double salary;
	@Override
	public int compareTo(Emp o) {//负数：小于，0等于，正数大于
		if(this.salary>o.salary){
			return 1;
		}else if(this.salary<o.salary){
			return -1;
		}else{
			if(this.id>o.id){
				return 1;
			}else if(this.id<o.id){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",name:"+name+",salary:"+salary;
	}
}