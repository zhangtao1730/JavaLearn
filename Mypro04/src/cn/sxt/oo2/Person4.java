package cn.sxt.oo2;

/**
 * ²âÊÔ·â×°
 * @author Administrator
 *
 */
public class Person4 {
	private int id;
	private String name;
	private int age;
	private boolean man;
	
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		if(age>=1&&age<=130){
			this.age=age;
		}else{
			System.out.println("ÇëÊäÈëÕı³£ÄêÁä");
		}
	}
}
