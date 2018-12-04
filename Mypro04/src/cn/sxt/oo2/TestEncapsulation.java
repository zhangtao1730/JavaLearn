package cn.sxt.oo2;

/**
 * 测试封装
 * @author Administrator
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h=new Human();
//		h.age=13;
		h.name="张三";
		h.height=230;
		Person4 p4=new Person4();
		p4.setName("张三");
		p4.setAge(-14);
	}
}


class Boy extends Human{
	void sayHello(){
//		System.out.println(age); //子类无法使用父类的私有属性和方法；
	}
}