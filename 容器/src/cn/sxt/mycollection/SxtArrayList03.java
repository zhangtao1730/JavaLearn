package cn.sxt.mycollection;

/**
 * 自定义实现ArrayList,体会底层原理
 * 增加数组扩容功能
 * @author Administrator
 *
 */
public class SxtArrayList03<E> {

	private Object[] elementData;
	private int size;
	
	private static final int DEFAULT_CAPACITY=10;
	
	public SxtArrayList03(){
		elementData=new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList03(int capacity){
		elementData=new Object[capacity];
	}
	
	public void add(E element){
		
		//什么时候扩容？？
		if(size==elementData.length){
			//扩容操作
			Object[] newArray=new Object[elementData.length+(elementData.length>>1)];//10+10/2
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData=newArray;
		}
		elementData[size++]=element;
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
		SxtArrayList03 s1=new SxtArrayList03();
		for(int i =0;i<40;i++){
			s1.add("张"+i);
		}
		System.out.println(s1);
	}
}
