package cn.sxt.oo2;

/**
 * ���Է�װ
 * @author Administrator
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h=new Human();
//		h.age=13;
		h.name="����";
		h.height=230;
		Person4 p4=new Person4();
		p4.setName("����");
		p4.setAge(-14);
	}
}


class Boy extends Human{
	void sayHello(){
//		System.out.println(age); //�����޷�ʹ�ø����˽�����Ժͷ�����
	}
}