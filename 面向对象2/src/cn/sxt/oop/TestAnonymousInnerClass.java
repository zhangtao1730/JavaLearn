package cn.sxt.oop;

public class TestAnonymousInnerClass {
	
	public static void test01(AA a){
		System.out.println("#############");
		a.aa();
	}
	public static void main(String[] args) {
		TestAnonymousInnerClass.test01(new AA(){

			@Override
			public void aa() {
				System.out.println("aaa");
			}
			
		});
	}
}

interface AA{
	void aa();
}

