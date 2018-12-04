package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author Administrator
 *
 */
public class MyGameFrame extends Frame{
	
	
	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane =new Plane(planeImg,350,350);
	Shell[] shells=new Shell[30];
	Explode bao;
	Date starTime=new Date();
	Date endTime;
	int period;//��Ϸ����ʱ��
	private Date startTime;
	
	@Override
	public void paint(Graphics g) {//g�൱��һֻ����
		// TODO Auto-generated method stub
		super.paint(g);
		Color c =g.getColor();
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		//���������ڵ�
		for(int i=0;i<shells.length;i++){
			shells[i].draw(g);
			//�ɻ����ڵ�����ײ���
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng){
				plane.live=false;
				if(bao ==null){
					bao=new Explode(plane.x,plane.y);
					endTime=new Date();
					period=(int)((endTime.getTime()-startTime.getTime())/1000);
				}

				bao.draw(g);
			}
		}
		if(!plane.live){
			g.setColor(Color.red);
			Font f=new Font("����",Font.BOLD,50);
			g.setFont(f);
			g.drawString("��Ϸʱ�䣺"+ period+"��", (int)250, (int)250);
		}
		g.setColor(c);
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
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	/**
	 * ��ʼ������
	 */
	public void launchFram(){
		this.setTitle("�ɻ���Ϸ");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(50, 100);
		this.addWindowListener (new WindowAdapter (){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		new PaintThread().start();//�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());//���̼���
		
		//��ʼ��50���ڵ�
		for(int i=0;i<shells.length;i++){
			shells[i]=new Shell();
		}
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFram();
	}
	
	
	//˫����
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
}
