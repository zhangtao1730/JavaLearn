package cn.sxt.game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 * @author Administrator
 *
 */
public class MyGameFrame extends Frame{
	
	
	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane =new Plane(planeImg,250,250);
	Shell[] shells=new Shell[50];
	
	@Override
	public void paint(Graphics g) {//g相当于一只画笔
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		//画出所有炮弹
		for(int i=0;i<shells.length;i++){
			shells[i].draw(g);
			//飞机和炮弹的碰撞检测
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng){
				plane.live=false;
			}
		}


	}

	//帮助我们反复的重画窗口
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true){
//				System.out.println("窗口重画一次");
				repaint();//重画
				
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
	 * 键盘监听内部类
	 * @author Administrator
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	/**
	 * 初始化窗口
	 */
	public void launchFram(){
		this.setTitle("飞机游戏");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(50, 100);
		this.addWindowListener (new WindowAdapter (){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		new PaintThread().start();//启动重画窗口的线程
		addKeyListener(new KeyMonitor());//键盘监听
		
		//初始化50个炮弹
		for(int i=0;i<shells.length;i++){
			shells[i]=new Shell();
		}
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFram();
	}
	
	
	//双缓冲
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
}
