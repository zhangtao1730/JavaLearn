package cn.sxt.array2;

import java.util.Arrays;

/**
 * ��������洢�������
 * @author Administrator
 *
 */
public class TestArrayTableData {
	public static void main(String[] args) {
		Object[] a1 = {1001,"���",18,"��ʦ","2006-2-14"};
		Object[] a2 = {1002,"��С��",19,"����","2007-10-10"};
		Object[] a3 = {1003,"��С��",20,"������","2008-5-5"};
		
		Object[][] tableData = new Object[3][];
		tableData[0]=a1;
		tableData[1]=a2;
		tableData[2]=a3;
		for(Object[] temp:tableData){
			System.out.println(Arrays.toString(temp));
		}
		
	}
}
