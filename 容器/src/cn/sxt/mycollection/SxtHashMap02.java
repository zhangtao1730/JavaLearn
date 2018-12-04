package cn.sxt.mycollection;

/**
 * �Զ���HashMap
 * ʵ����toString����鿴Map�еļ��ֶ���ȡ
 * @author Administrator
 *
 */
public class SxtHashMap02 {
	Node2[] table;//λͰ���� bucket array
	int size;//��ŵļ�ֵ�Եĸ���
	public SxtHashMap02(){
		table =new Node2[16];//����һ�㶨���2��������
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("{");
		
		for(int i=0;i<table.length;i++){
			Node2 temp=table[i];
			while(temp!=null){
				sb.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	public void put(Object key,Object value){
		//�������µĽڵ����
		Node2 newNode=new Node2();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		Node2 temp = table[newNode.hash];
		
		Node2 iterLast=null;//���ڱ��������һ��Ԫ��
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
		SxtHashMap02 m=new SxtHashMap02();
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
	}
	public static int myHash(int v,int length){
//		System.out.println("hash in myHash:"+ (v&(length-1)));//ֱ��λ����Ч�ʸ�
//		System.out.println("hash in myHash:"+ (v%length));//ȡ�����㡣Ч�ʵ�
		return v&(length-1);
	}
}


