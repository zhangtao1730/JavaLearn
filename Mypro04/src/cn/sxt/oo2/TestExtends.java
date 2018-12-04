package cn.sxt.oo2;
/**
 * 测试继承
 * @author Administrator
 *
 */
public class TestExtends {
	public static void main(String[] args){
		Student stu=new Student();
		stu.name="高琪";
		stu.height=172;
		stu.rest();
		
		Student stu2=new Student("张三",16,"吃鸡");
		System.out.println(stu2 instanceof Student);
		System.out.println(stu2 instanceof Person);
	}
}

class Person{
	String name;
	int height;
	
	public void rest(){
		System.out.println("休息一会");
	}
}

class Student extends Person{
	String major;
	
	public void sutdy(){
		System.out.println("学习两小时");
	}
	public Student(String name, int height,String major){
		this.name=name;
		this.height=height;
		this.major=major;
	}
	public Student(){
		
	}
}