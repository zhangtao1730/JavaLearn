
public class SxtStu {
	//属性fields
	int id;
	String name;
	int age;
	
	Computer comp;//计算机
	
	void study(){
		System.out.println("学习。使用电脑："+comp.brand);
	};
	void play(){
		System.out.println("吃鸡");
	}
	//构造方法，用于创建这个类的对象。无参的构造方法可以由系统自动创建
	SxtStu(){
	}
	
	public static void main(String[] args){
		SxtStu stu = new SxtStu();//创建一个对象
		stu.id=1001;
		stu.name="张韬";
		stu.age=18;
		
		Computer c1 = new Computer();
		c1.brand="联想";
		stu.comp=c1;
		stu.play();
		stu.study();
	}
}

class Computer{
	//品牌
	String brand;
}