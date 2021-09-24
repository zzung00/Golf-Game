package golfapp;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import scene.SceneManagement;

public class GolfApp extends JFrame implements Runnable {
	private SceneManagement sm;
	
	public static void main(String[] args) {
		Thread thread = new Thread(new GolfApp());
		thread.start();
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		
		while(true) {
			try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			long now = System.nanoTime();
			double delta = (now - start)/1000000000.0;
			sm.update(delta);
			repaint();
			if (delta >= 1)  
				start = now;
		}
	}
	
	public GolfApp() {
		super("GolfApp");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		sm = new SceneManagement(this);
		sm.changeScene(0);
		setBackground(Color.black);
	}

	public void paintComponent(Graphics g) {
		
	}

}
