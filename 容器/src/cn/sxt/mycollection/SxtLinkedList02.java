package cn.sxt.mycollection;

import javax.management.RuntimeErrorException;

/**
 * 自定义一个链表
 * 增加get方法
 * @author Administrator
 *
 */
public class SxtLinkedList02 {

	private Node first;
	private Node last;
	private int size;
	
	public Object get(int index){
		if(index<0 || index>size-1){
			throw new RuntimeException("索引数字不合法："+index);
		}
		//[] 
		//["a","b","c","d","e","f"] 2
		Node temp=null;
		if(index<=(size>>1)){//右移一位除以二
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.next;
			}
		}else{
			temp=last;
			for(int i=size-1;i>index;i--){
				temp=temp.previous;
			}
		}
		
		return temp.element;
	}

	public void add(Object obj){
		Node node=new Node(obj);
		if(first==null){
			first=node;
			last=node;
		}else{
			node.previous=last;
			node.next=null;
			last.next=node;
			last=node;
		}
		size++;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		//挨个遍历链表中的元素
		//["a","b","c"]
		Node temp=first;
		while(temp!=null){
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');

		return sb.toString();
	}
	public static void main(String[] args) {
		SxtLinkedList02 list=new SxtLinkedList02();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		System.out.println(list.get(1));
	}
}
