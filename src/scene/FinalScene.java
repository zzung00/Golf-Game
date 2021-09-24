package scene;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import object.Ball;
import object.Hole;

public class FinalScene extends GolfAppScene {
	private BufferedImage holeGround, succesMark, succesMark2;
	private Hole hole;
	private Ball ball;
	private int x, y;
	private int angle = 0;
	private int mouseX, mouseY;
	private float dash[] = {20, 20f};
	private boolean isFinish;
	private JPanel menuPanel;
	private JButton btnExit;
	
	
	public FinalScene(SceneManagement sm) {
		super(sm);
		try {
			holeGround = ImageIO.read(new File("res/홀그라운드.png"));
			hole = new Hole();
			ball = new Ball();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		x = (int)(Math.random()*700);
		y = (int)(Math.random()*500);
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
		});
		
		super.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = mouseX;
				y = mouseY;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		isFinish = false;
		
		try {
			succesMark = ImageIO.read(new File("res/성공표시.jpg.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setSize(200, 80);
		menuPanel.setLocation(340, 280);
		menuPanel.setBackground(new Color(224, 255, 255));
		menuPanel.setOpaque(true);
		menuPanel.setVisible(false);
		add(menuPanel);
		btnExit = new JButton();
		btnExit = new JButton(new ImageIcon("res/final게임종료.png"));
		btnExit.setRolloverIcon(new ImageIcon("res/final게임종료2.png"));
		btnExit.setSize(95, 35);
		btnExit.setLocation(0, 0);
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(false);
		btnExit.setVisible(true);
		menuPanel.setSize(btnExit.getWidth(), btnExit.getHeight());
		menuPanel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		menuPanel.setSize(btnExit.getSize());
		
	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(holeGround, 0, 0, null);
		hole.draw(g);
		ball.draw(g);
		g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1, dash,0));
		g2.drawLine(ball.getX() + ball.getWidth() / 2,ball.getY() + ball.getHeight() / 2, mouseX, mouseY);
		
		if(isFinish) {
			g.drawImage(succesMark, 300, 200, null);
		}
	}
	
	public float lerp(float v0, float v1, float t) {
		return v0 + t * (v1 - v0);
	}
	
	@Override
	public void update(double delta) {
		if (!isFinish) {
			int ballX = (int) lerp(ball.getX(), x, 0.03f);
			int ballY = (int) lerp(ball.getY(), y, 0.03f);
			ball.setX(ballX);
			ball.setY(ballY);
			if (hole.contains(new Point2D.Float(ball.getCenterX(), ball.getCenterY()))) {
				menuPanel.setVisible(true);
				isFinish = true;
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
