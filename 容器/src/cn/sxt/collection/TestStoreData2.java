package cn.sxt.collection;

/**
 * ���Ա�����ݵĴ洢
 * ���ORM˼��
 * ÿһ������ʹ��javabean����洢������ʹ�÷ŵ�map��list
 * @author Administrator
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User user1=new User(1001,"����",20000,"2018.5.5");
		User user2=new User(1002,"����",30000,"2005.4.4");
		User user3=new User(1003,"����",3000,"2020.5.4");
	}
}

class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public User(){
		
	}
}