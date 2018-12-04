package cn.sxt.mycollection;

/**
 * �Զ���HashMap
 * ʵ����put�������Ӽ�ֵ�ԡ�
 * @author Administrator
 *
 */
public class SxtHashMap01 {
	Node2[] table;//λͰ���� bucket array
	int size;//��ŵļ�ֵ�Եĸ���
	public SxtHashMap01(){
		table =new Node2[16];//����һ�㶨���2��������
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
			}
		}
	}
	
	public static void main(String[] args) {
		SxtHashMap01 m=new SxtHashMap01();
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


