package cn.sxt.game;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author Administrator
 *
 */
public class MyGameFrame extends JFrame{
	/**
	 * ��ʼ������
	 */
	public void launchFram(){
		this.setTitle("�ɻ���Ϸ");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(50, 100);
		this.addWindowListener (new WindowAdapter (){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFram();
	}
}
