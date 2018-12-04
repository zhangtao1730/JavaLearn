package cn.sxt.test;
/**
 * 测试自动装箱，自动拆箱
 * @author Administrator
 *
 */
public class TestAutoBox {
	public static void main(String[] args) {
		Integer a=234;//Integer a=Integer.valueOf(234);

		int b=a; 
		Integer c=null;
		if(c!=null){
			int d =c;
		}
		
		//缓存[-128,127]之间的数字.实际就是系统初始的时候创建了[-128,127]之间的一个数组
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        System.out.println(in1 == in2);//true 因为123在缓存范围内
        System.out.println(in1.equals(in2));//true
        System.out.println("###############");
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//false 因为1234不在缓存范围内
        System.out.println(in3.equals(in4));//true
	}
}
