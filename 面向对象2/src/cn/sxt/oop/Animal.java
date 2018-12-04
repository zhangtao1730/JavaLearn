package cn.sxt.oop;
/**
 * 抽象类的意义：为子类提供统一的规范的模板子类必须实现相关的抽象放方法！
 * @author Administrator
 *
 */
public abstract class Animal {
	
	//第一:没有实现。第二：子类必须实现
	abstract public void shout();
	
	public void run(){
		System.out.println("跑");
	}
}

class Dog extends Animal{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		
	}
	
}