package cn.sxt.mycollection;

/**
 * �Զ���HashMap
 * ʵ��get����,���ݼ������ö�Ӧ��ֵ����
 * @author Administrator
 *
 */
public class SxtHashMap04<K,V> {
	Node3[] table;//λͰ���� bucket array
	int size;//��ŵļ�ֵ�Եĸ���
	public SxtHashMap04(){
		table =new Node3[16];//����һ�㶨���2��������
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key){
		
		int hash=myHash(key.hashCode(),table.length);
		V value=null;
		if(table[hash]!=null){
			Node3 temp=table[hash];
			while(temp!=null){
				if(temp.key.equals(key)){//�������򷵻ض�Ӧ��value
					value=(V)temp.value;
					break;
				}else{
					temp=temp.next;
				}
			}
		}
		
		return value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("{");
		
		for(int i=0;i<table.length;i++){
			Node3 temp=table[i];
			while(temp!=null){
				sb.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	@SuppressWarnings("unchecked")
	public void put(K key,V value){
		
		//���Ҫ���ƣ�����Ҫ�����������ݵ����⡣
		//�������µĽڵ����
		Node3 newNode=new Node3();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		Node3 temp = table[newNode.hash];
		
		Node3 iterLast=null;//���ڱ��������һ��Ԫ��
		boolean keyRepeat=false;
		if(temp==null){
			//�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode.hash]=newNode;
			size++;
		}else{
			//�˴�����Ԫ�ز�Ϊ�գ��������Ӧ����
			while(temp!=null){
				//�ж�key����ظ��򸲸�
				if(temp.key.equals(key)){
					keyRepeat=true;
					System.out.println("key�ظ��ˣ�����");
					temp.value=newNode.value;
					break;
				}else{
					//key���ظ����������һ��
					iterLast=temp;
					temp=temp.next;
				}
			}
			if(!keyRepeat){//���û�з���key�ظ������������ӵ��������
				iterLast.next=newNode;
				size++;
			}
		}
	}
	public static void main(String[] args) {
		SxtHashMap04<Integer,String> m=new SxtHashMap04<>();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "sss");
		
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");
		System.out.println(m);
		
//		for(int i =10;i<100;i++){
//			System.out.println(i+"---"+myHash(i,16));//52,69,85
//		}
		System.out.println(m.get(69));
	}
	public static int myHash(int v,int length){
//		System.out.println("hash in myHash:"+ (v&(length-1)));//ֱ��λ����Ч�ʸ�
//		System.out.println("hash in myHash:"+ (v%length));//ȡ�����㡣Ч�ʵ�
		return v&(length-1);
	}
}


