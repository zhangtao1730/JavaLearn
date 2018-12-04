package com.learn.thread;
/**
 * lambda推导 + 参数+返回值
 * @author zhangtao
 *
 */
public class LambdaTest03 {
	public static void main(String[] args) {
		IInterest interest=(int a,int c)-> {
			System.out.println("i like lambda--->"+(a+c));
			return a+c;
		};
		interest.lambda(100, 200);

		interest=(a,c)-> {
			System.out.println("i like lambda--->"+(a+c));
			return a+c;
		};
		interest.lambda(200, 200);
		//一行代码
		interest=(a,c)-> a+c;
		System.out.println(interest.lambda(10, 20));
	}

}

interface IInterest{
	int lambda(int a,int b);
}
//外部类
class Interest implements IInterest{

	@Override
	public int lambda(int a,int c) {
		System.out.println("i like lambda--->"+(a+c));
		return a+c;
	}
	
}