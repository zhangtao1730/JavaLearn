package cn.sxt.oo2;
/**
 * ���Զ�̬
 * @author Administrator
 *
 */
public class TestPolym {
	public static void main(String[] args) {
		Animal a = new Animal();
		animalCry(a);
		Dog d=new Dog();
		animalCry(d);
		Cat c=new Cat();
		animalCry(c);
	}
	static void animalCry(Animal a){
		a.shout();
	}
}

class Animal{
	public void shout(){
		System.out.println("����һ��");
	}
}
class Dog extends Animal{
	public void shout(){
		System.out.println("������");
	}
}
class Cat extends Animal{
	public void shout(){
		System.out.println("������");
	}
}