package cn.sxt.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 使用try/catch处理异常
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		readMyfile();
	}
	
	public static void readMyfile(){
		FileReader reader = null;
		try {
			reader=new FileReader("d:/a.txt");
			char c1 = (char)reader.read();
			System.out.println(c1);
		} catch (FileNotFoundException e) {//子类异常在父类异常前面
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
