package cn.sxt.mycollection;

/**
 * �Զ���ʵ��ArrayList,���ײ�ԭ��
 * ����set��get����
 * ��������߽���
 * @author Administrator
 *
 */
public class SxtArrayList04<E> {

	private Object[] elementData;
	private int size;
	
	private static final int DEFAULT_CAPACITY=10;
	
	public SxtArrayList04(){
		elementData=new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList04(int capacity){
		if(capacity<0){
			throw new RuntimeException("��������������Ϊ����");
		}else if(capacity==0){
			elementData=new Object[DEFAULT_CAPACITY];
		}else{
			elementData=new Object[capacity];
		}
		
	}
	
	public void add(E element){
		
		//ʲôʱ�����ݣ���
		if(size==elementData.length){
			//���ݲ���
			Object[] newArray=new Object[elementData.length+(elementData.length>>1)];//10+10/2
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData=newArray;
		}
		elementData[size++]=element;
	}
	
	public E get(int index){
		checkRange(index);
		return (E)elementData[index];
	}
	
	public void set(E element,int index){
		checkRange(index);
		elementData[index]=element;
	}
	
	public void checkRange(int index){
		//�����Ϸ��ж�[0,size)
		if(index<0 || index>size-1){
			//���Ϸ�
			throw new RuntimeException("�������Ϸ���"+index);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		//[a,b,c]
		sb.append("[");
		for(int i=0;i<size;i++){
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	

	public static void main(String[] args) {
		SxtArrayList04 s1=new SxtArrayList04();
		for(int i =0;i<40;i++){
			s1.add("��"+i);
		}

		s1.set("ddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(10));
		
	}
}
