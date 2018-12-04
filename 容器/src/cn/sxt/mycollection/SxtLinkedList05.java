package cn.sxt.mycollection;


/**
 * 自定义一个链表
 * 增加泛型
 * @author Administrator
 *
 */
public class SxtLinkedList05<E> {

	private Node first;
	private Node last;
	private int size;
	
	
	
	public void add(int index,E element){
		checkRange(index);
		Node newNode=new Node(element);
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
		checkRange(index);
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
			//被删除的元素是第一个元素时
			if(index==0){
				first=down;
			}
			//被删除的元素是最后一个元素时
			if(index==size-1){
				last=up;
			}
			size--;
		}
	}
	@SuppressWarnings("unchecked")
	public E get(int index){
		checkRange(index);
		//[] 
		//["a","b","c","d","e","f"] 2
		Node temp=getNode(index);
		return temp!=null?(E)temp.element:null;
	}
	private void checkRange(int index){
		if(index<0 || index>size-1){
			throw new RuntimeException("索引数字不合法："+index);
		}
	}
	private Node getNode(int index){
		checkRange(index);
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
		return temp;
	}
	
	public void add(E element){
		Node node=new Node(element);
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
		SxtLinkedList05<String> list=new SxtLinkedList05<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		System.out.println(list);
		list.add(3,"老张");
		System.out.println(list);
		System.out.println(list.get(0));
	}
}
