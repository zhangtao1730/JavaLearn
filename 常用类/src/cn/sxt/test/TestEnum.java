package cn.sxt.test;

/**
 * 测试枚举类
 * @author Administrator
 *
 */
public class TestEnum {
	public static void main(String[] args) {
		System.out.println(Season.AUTUMN);
		Season a=Season.AUTUMN;
		switch(a){
		case SPRING:
			System.out.println("春天来了");
			break;
		case SUMMER:
			System.out.println("夏天来了");
		}
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINER
}
enum Week{
	星期一,星期二,星期三,星期四,星期五,星期六,星期日
}