package cn.sxt.array2;

/**
 * ���Զ�ά����
 * @author Administrator
 *
 */
public class Test2DimensionArray {
	public static void main(String[] args) {
		//int[] a=new int[3];
		//Car[] cars=new Car[3];
		int[][] a=new int[3][];
		a[0] = new int[]{20,30};
		a[1] = new int[]{10,15,80};
		a[2] = new int[]{50,60};
		System.out.println(a[1][2]);
		//��̬��ʼ����ά����
		int[][] b={
				{20,30,40},
				{50,20},
				{100,200,300,400}
		};
		System.out.println(b[0][2]);
	}
}

class Car{
	
}
