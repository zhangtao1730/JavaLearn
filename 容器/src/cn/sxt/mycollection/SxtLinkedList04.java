package cn.sxt.mycollection;

import javax.management.RuntimeErrorException;

/**
 * �Զ���һ������
 * ���Ӳ���ڵ�
 * @author Administrator
 *
 */
public class SxtLinkedList04 {

	private Node first;
	private Node last;
	private int size;
	
	
	
	public void add(int index,Object obj){
		//check range;
		Node newNode=new Node(obj);
		Node temp=getNode(index);
		if(index==0){
			first=newNode;
			first.next=temp;
			temp.previous=first;
		}else if(index==size-1){
			last=newNode;
			last.previous=temp;
			temp.next=last;
		}else if(temp!=null){
			Node up=temp.previous;
			up.next=newNode;
			newNode.previous=up;
			newNode.next=temp;
			temp.previous=newNode;
		}
		size++;
	}
	
	public void remove(int index){
		Node temp=getNode(index);
		if(temp!=null){
			Node up=temp.previous;
			Node down=temp.next;
			if(up!=null){
				up.next = down;
			}
			if(down!=null){
				down.previous=up;
			}
			//��ɾ����Ԫ���ǵ�һ��Ԫ��ʱ
			if(index==0){
				first=down;
			}
			//��ɾ����Ԫ�������һ��Ԫ��ʱ
			if(index==size-1){
				last=up;
			}
			size--;
		}
	}
	public Object get(int index){
		if(index<0 || index>size-1){
			throw new RuntimeException("�������ֲ��Ϸ���"+index);
		}
		//[] 
		//["a","b","c","d","e","f"] 2
		Node temp=getNode(index);
		return temp.element;
	}

	public Node getNode(int index){
		Node temp=null;
		
		if(index<=(size>>1)){//����һλ���Զ�
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
		return temp;
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
		//�������������е�Ԫ��
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
		SxtLinkedList04 list=new SxtLinkedList04();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		System.out.println(list);
		list.add(6,"����");
		System.out.println(list);
	}
}
