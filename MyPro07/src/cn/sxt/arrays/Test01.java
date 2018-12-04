package cn.sxt.arrays;

public class Test01 {
	public static void main(String[] args) {
		int[] arr01=new int[10];
		String[] arr02 = new String[5];

		
		arr01[0]=13;
		for(int i=0;i<arr01.length;i++){
			arr01[i]=10*i;
		}
		for(int i=0;i<arr01.length;i++){
			System.out.println(arr01[i]);
		}
		
		User[] arr03 = new User[3];
		arr03[0]=new User(1001,"张三");
		arr03[1]=new User(1002,"李四");
		arr03[2]=new User(1003,"王五");
		for(int i=0;i<arr03.length;i++){
			System.out.println(arr03[i].getName());
		}
	}
}

