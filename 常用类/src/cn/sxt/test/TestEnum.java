package cn.sxt.test;

/**
 * ����ö����
 * @author Administrator
 *
 */
public class TestEnum {
	public static void main(String[] args) {
		System.out.println(Season.AUTUMN);
		Season a=Season.AUTUMN;
		switch(a){
		case SPRING:
			System.out.println("��������");
			break;
		case SUMMER:
			System.out.println("��������");
		}
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINER
}
enum Week{
	����һ,���ڶ�,������,������,������,������,������
}