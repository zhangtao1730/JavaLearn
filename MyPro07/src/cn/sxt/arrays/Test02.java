package cn.sxt.arrays;

public class Test02 {
	public static void main(String[] args) {
		//静态初始化
		int a[]={1,2,3};
		User[] b={
				new User(1001,"张三"),
				new User(1002,"李四"),};
		//默认初始化
		int[] c=new int[3];
		//动态初始化
		int d[]=new int[2];
		d[0]=1;
		d[1]=2;
	}
}
