package object;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Ball {
	private BufferedImage image;
	private int x, y;
	private Body ball;
	private BodyDef bodydef = new BodyDef();
	private PolygonShape octagon = new PolygonShape();
	private CircleShape circle= new CircleShape();
	private FixtureDef fixture = new FixtureDef();
	private float velocity = 30.0f;
	
	public Ball(World world) throws IOException {
		image = ImageIO.read(new File("res/°ñÇÁ°ø.png"));
		x = 0;
		y = 500;
		bodydef.setType(BodyType.DYNAMIC);
		bodydef.position.set(x, y);
		ball = world.createBody(bodydef);
		
		/*Vec2 vertexArray[] = new Vec2[8];
		vertexArray[0] = new Vec2(-7.5f, 0.0f);
		vertexArray[1] = new Vec2(-5.0f, 5.0f);
		vertexArray[2] = new Vec2(-5.0f, -5.0f);
		vertexArray[3] = new Vec2(0.0f, 7.5f);
		vertexArray[4] = new Vec2(0.0f, -7.5f);
		vertexArray[5] = new Vec2(5.0f, 5.0f);
		vertexArray[6] = new Vec2(5.0f, -5.0f);
		vertexArray[7] = new Vec2(7.5f, 0.0f);
		octagon.set(vertexArray, 8);*/
		
		circle.setRadius(image.getWidth()/2);
		fixture.shape = circle;
		fixture.density = 1.0f;
		fixture.friction = 0.8f;
		fixture.restitution = 1.0f;
		ball.createFixture(fixture);
		
	
	}
	
	public void update(int cameraX, int cameraY) {
		x = ((int)(ball.getPosition().x - cameraX));
		y = ((int)(ball.getPosition().y - cameraY));
	}
	
	public Body getBody() {
		return ball;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
	public Ball() throws IOException {
		image = ImageIO.read(new File("res/°ñÇÁ°ø.png"));
	}
	
	public int getCenterX() {
		return x + image.getWidth() / 2;
	}
	
	public int getCenterY() {
		return y + image.getHeight() / 2;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
}
