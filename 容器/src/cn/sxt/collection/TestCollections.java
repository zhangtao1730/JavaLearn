package cn.sxt.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections�������ʹ��
 * Collection�ǽӿڣ�Collectionsʱ������
 * @author Administrator
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add("��"+i);
		}
		System.out.println(list);
		Collections.shuffle(list);//�������list�е�Ԫ��
		System.out.println(list);
		
		Collections.reverse(list);//��������
		System.out.println(list);
		
		Collections.sort(list);//���������ķ�ʽ�����Զ������ʹ�ã�Compar�ӿ�
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "��1"));//�۰����
	}
}
