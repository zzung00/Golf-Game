package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TitleScene extends GolfAppScene {
	private JButton btnStart;
	private JButton btnClose; 
	private BufferedImage background;
	private JLabel label = new JLabel("Golf Game");
	private JPanel mapchoice = new JPanel();
	private JButton btn1st, btn2nd, btn3rd;

	public TitleScene(SceneManagement sm) {
		super(sm);
		try {
			background = ImageIO.read(new File("res/골프게임타이틀배경.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		label.setSize(300, 250);
		label.setLocation(280, 30);
		label.setFont(new Font("Script MT Bold", Font.PLAIN, 50));
		label.setVisible(true);
		add(label, 1);
		btnStart = new JButton(new ImageIcon("res/골프게임게임시작버튼1.png"));
		btnStart.setRolloverIcon(new ImageIcon("res/골프게임시작버튼2.png"));
		btnStart.setSize(125, 30);
		btnStart.setLocation(320, 240);
		btnStart.setBorderPainted(false);
		btnStart.setVisible(true);
		add(btnStart, 1);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				change();
				btnStart.setEnabled(false);
				btnClose.setEnabled(false);
			}
			
		});
		btnClose = new JButton(new ImageIcon("res/골프게임게임종료버튼.png"));
		btnClose.setRolloverIcon(new ImageIcon("res/골프게임종료버튼2.png"));
		btnClose.setSize(125, 30);
		btnClose.setLocation(320, 285);
		btnClose.setBorderPainted(false);
		btnClose.setVisible(true);
		add(btnClose, 1);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
	
	public void change() {
		mapchoice.setLayout(null);
		mapchoice.setSize(220, 350);
		mapchoice.setLocation(280, 120);
		mapchoice.setBackground(new Color(245, 235, 200));
		btn1st = new JButton(new ImageIcon("res/맵선택힐스.png"));
		btn1st.setRolloverIcon(new ImageIcon("res/맵선택힐스2.png"));
		btn1st.setSize(105, 30);
		btn1st.setLocation(60, 100);
		btn1st.setBorderPainted(false);
		btn1st.setVisible(true);
		mapchoice.add(btn1st);
		btn1st.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sm.changeScene(1);
			}
			
		});
		btn2nd = new JButton(new ImageIcon("res/맵선택밸리.png"));
		btn2nd.setSize(105, 30);
		btn2nd.setLocation(60, 150);
		btn2nd.setBorderPainted(false);
		btn2nd.setVisible(true);
		btn2nd.setEnabled(false);
		mapchoice.add(btn2nd);
		btn3rd = new JButton(new ImageIcon("res/맵선택레이크.png"));
		btn3rd.setSize(105, 30);
		btn3rd.setLocation(60, 200);
		btn3rd.setBorderPainted(false);
		btn3rd.setVisible(true);
		btn3rd.setEnabled(false);
		mapchoice.add(btn3rd);
		mapchoice.setVisible(true);
		add(mapchoice, 0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}
}

