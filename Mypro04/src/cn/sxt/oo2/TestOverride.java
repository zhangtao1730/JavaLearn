package cn.sxt.oo2;

/**
 * 测试重写(override)覆盖
 * @author Administrator
 *
 */
public class TestOverride {
	public static void main(String[] args){
		Horse h=new Horse();
		h.run();
	}
}
class Vehicle{
	public void run(){
		System.out.println("跑。。");
	}
	public void stop(){
		System.out.println("停止");
	}
	public Person whoIsPsg(){
		return new Person();
	}
}

class Horse extends Vehicle{
	public void run(){
		System.out.println("四蹄翻飞，dedede");
	}
	public Student whoIsPsg(){//返回值类型小于等于父类型
		return new Student();
	}
}