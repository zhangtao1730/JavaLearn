package cn.sxt.oo2;
/**
 * ���Լ̳�
 * @author Administrator
 *
 */
public class TestExtends {
	public static void main(String[] args){
		Student stu=new Student();
		stu.name="����";
		stu.height=172;
		stu.rest();
		
		Student stu2=new Student("����",16,"�Լ�");
		System.out.println(stu2 instanceof Student);
		System.out.println(stu2 instanceof Person);
	}
}

class Person{
	String name;
	int height;
	
	public void rest(){
		System.out.println("��Ϣһ��");
	}
}

class Student extends Person{
	String major;
	
	public void sutdy(){
		System.out.println("ѧϰ��Сʱ");
	}
	public Student(String name, int height,String major){
		this.name=name;
		this.height=height;
		this.major=major;
	}
	public Student(){
		
	}
}