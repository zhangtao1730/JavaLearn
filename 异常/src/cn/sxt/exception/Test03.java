package cn.sxt.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 使用throws声明异常
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		try {
			readMyfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readMyfile() throws IOException{
		FileReader reader = null;
			reader=new FileReader("d:/a.txt");
			char c1 = (char)reader.read();
			System.out.println(c1);

				if(reader!=null){
					reader.close();

		}
	}
}
