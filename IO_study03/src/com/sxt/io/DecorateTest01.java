package com.sxt.io;

/**
 * ʵ�ַŴ����������ķŴ���
 * @author Administrator
 *
 */
public class DecorateTest01 {
	public static void main(String[] args) {
		Person p=new Person();
		p.say();
		//װ��
		Amplifier am=new Amplifier(p);
		am.say();
	}
}

interface Say{
	void say();
}
class Person implements Say{
	//����
	private int voice =10;
	@Override
	public void say() {
		System.out.println("�˵�������"+ this.getVoice());
		
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	
}

class Amplifier implements Say{
	private Person p;
	Amplifier(Person p){
		this.p=p;
	}
	@Override
	public void say() {
		System.out.println("�˵�������"+ p.getVoice()*100);
		System.out.println("����������");
		
	}
	
}