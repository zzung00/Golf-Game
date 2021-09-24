package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GaugeBar {
	private BufferedImage bar1, bar2;
	private double per = 0;
	private int x, y;
	
	public GaugeBar() throws IOException {
		bar1 = ImageIO.read(new File("res/게이지바1.png"));
		bar2 = ImageIO.read(new File("res/게이지바2.png"));
	}
	
	public void setPer(double per) {
		this.per = per;
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(bar1, 5, 560, null);
		g.drawImage(bar2, 7, 562, (int)(7 + bar2.getWidth()*per) , 562 + bar2.getHeight(), 0, 0, (int)(bar2.getWidth()*per), bar2.getHeight(), null);
	}
}
