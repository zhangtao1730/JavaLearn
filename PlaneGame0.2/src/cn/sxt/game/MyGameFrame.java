package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 * @author Administrator
 *
 */
public class MyGameFrame extends JFrame{
	Image ball = GameUtil.getImage("images/ball.png");
	@Override
	public void paint(Graphics g) {//g相当于一只画笔
		// TODO Auto-generated method stub
		super.paint(g);
		Color c=g.getColor();
		Font f=g.getFont();
		g.setColor(Color.BLUE);
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100,100, 40, 30);
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,50));
		g.drawString("打飞机", 200, 200);
		g.drawImage(ball, 100, 100, null);
		g.setColor(c);
		g.setFont(f);
	}
	/**
	 * 初始化窗口
	 */
	public void launchFram(){
		this.setTitle("飞机游戏");
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
