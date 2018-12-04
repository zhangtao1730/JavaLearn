package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author Administrator
 *
 */
public class MyGameFrame extends JFrame{
	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane =new Plane(planeImg,250,250);
	
	@Override
	public void paint(Graphics g) {//g�൱��һֻ����
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);

	}

	//�������Ƿ������ػ�����
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true){
//				System.out.println("�����ػ�һ��");
				repaint();//�ػ�
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 
	
	/**
	 * ���̼����ڲ���
	 * @author Administrator
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("����"+e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("̧��"+e.getKeyCode());
		}
		
	}
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
		new PaintThread().start();//�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());//���̼���
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFram();
	}
}
