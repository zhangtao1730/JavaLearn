
public class SxtStu {
	//����fields
	int id;
	String name;
	int age;
	
	Computer comp;//�����
	
	void study(){
		System.out.println("ѧϰ��ʹ�õ��ԣ�"+comp.brand);
	};
	void play(){
		System.out.println("�Լ�");
	}
	//���췽�������ڴ��������Ķ����޲εĹ��췽��������ϵͳ�Զ�����
	SxtStu(){
	}
	
	public static void main(String[] args){
		SxtStu stu = new SxtStu();//����һ������
		stu.id=1001;
		stu.name="���";
		stu.age=18;
		
		Computer c1 = new Computer();
		c1.brand="����";
		stu.comp=c1;
		stu.play();
		stu.study();
	}
}

class Computer{
	//Ʒ��
	String brand;
}