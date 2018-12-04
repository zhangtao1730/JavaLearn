package cn.sxt.collection;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行使用放到map或list
 * @author Administrator
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User user1=new User(1001,"张三",20000,"2018.5.5");
		User user2=new User(1002,"李四",30000,"2005.4.4");
		User user3=new User(1003,"王五",3000,"2020.5.4");
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