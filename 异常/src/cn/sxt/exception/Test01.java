package cn.sxt.exception;

public class Test01 {
 public static void main(String[] args) {
	int a=0;
	int b=1;
	if(a!=0){
		System.out.println(b/a);
	}
	String str =null;
	if(str!=null)
		str.length();
	
	Animal d =new Dog();
	if(d instanceof Cat){
		Cat c=(Cat)d;
	}
		
}
}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}