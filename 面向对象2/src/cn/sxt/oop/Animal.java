package cn.sxt.oop;
/**
 * ����������壺Ϊ�����ṩͳһ�Ĺ淶��ģ���������ʵ����صĳ���ŷ�����
 * @author Administrator
 *
 */
public abstract class Animal {
	
	//��һ:û��ʵ�֡��ڶ����������ʵ��
	abstract public void shout();
	
	public void run(){
		System.out.println("��");
	}
}

class Dog extends Animal{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		
	}
	
}