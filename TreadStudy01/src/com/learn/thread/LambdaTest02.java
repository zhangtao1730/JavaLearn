package com.learn.thread;
/**
 * lambda�Ƶ� + ����
 * @author zhangtao
 *
 */
public class LambdaTest02 {
	public static void main(String[] args) {
		ILove love=(int a) ->{
			System.out.println("i like lambda--->"+a);
		};
		love.lambda(100);
		//��
		love=(a) ->{
			System.out.println("i like lambda--->"+a);
		};
		love.lambda(50);

		love=a ->{
			System.out.println("i like lambda--->"+a);
		};
		love.lambda(10);
		
		love=a ->System.out.println("i like lambda--->"+a);
		love.lambda(5);
		
	}

}

interface ILove{
	void lambda(int a);
}
//�ⲿ��
class Love implements ILove{

	@Override
	public void lambda(int a) {
		System.out.println("i like lambda--->"+a);
	}
	
}