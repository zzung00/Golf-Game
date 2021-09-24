package object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hole {
	private BufferedImage hole;
	private int x, y;
	Ellipse2D e;
	
	public Hole() {
		
		try {
			hole = ImageIO.read(new File("res/Ȧ.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		x = (int)(Math.random()*800 - hole.getWidth());
		y = (int)(Math.random()*600 - hole.getHeight());
		e = new Ellipse2D.Float(x + 8, y + 38, 18, 18);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(hole, x, y, null);
		g2.draw(e);
	}
	
	public boolean contains(Rectangle2D r) {
		return e.contains(r);
	}
	
	public boolean contains(Point2D p) {
		return e.contains(p);
	}
	
	
	
}
