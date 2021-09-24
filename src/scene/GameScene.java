package scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;

import object.Ball;
import object.Camera;
import object.GaugeBar;
import object.Ground;

public class GameScene extends GolfAppScene implements ContactListener {
	private BufferedImage background, cloud1, cloud2, spacebar;
	private Ball ball;
	private Ground ground;
	private GaugeBar gaugebar;
	private Camera camera;
	int x1 = 0, x2 = 0;
	int a = 1;
	double per = 0;
	double inde = 0.05;
	private Vec2 gravity = new Vec2(0.0f, 10.0f);
	private World world = new World(gravity);
	private int velocityIterations = 6;
	private int positionIterations = 2;
	
	public GameScene(SceneManagement sm) {
		super(sm);
		try {
			background = ImageIO.read(new File("res/골프장배경.png"));
			cloud1 = ImageIO.read(new File("res/구름1.png"));
			cloud2 = ImageIO.read(new File("res/구름2.png"));
			spacebar = ImageIO.read(new File("res/스페이스바.png"));
			ball = new Ball(world);
			ground = new Ground(world);
			gaugebar = new GaugeBar();
			camera = new Camera();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		world.setContinuousPhysics(true);
		world.setContactListener(this);
	}
	
	@Override
	public void update(double delta) {
		x1+=a;
		x2+=a;
		if(x1 >= 800) {
			x1 = -cloud1.getWidth();
		}
		if(x2 >= 400) {
			x2 = -400-cloud2.getWidth();
		}
		world.step((float)1/30, velocityIterations, positionIterations);
		ball.update(camera.getX(), camera.getY());
		camera.update(ball);
		
		if(ball.getBody().getPosition().x >= 1300) {
			sm.changeScene(2);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0 - camera.getX(), 0 - camera.getY(), null);
		g.drawImage(cloud1, 0+x1 - camera.getX(), 5 - camera.getY(), null);
		g.drawImage(cloud2, 400+x2 - camera.getX(), 50 - camera.getY(), null);
		g.drawImage(spacebar, 10, 400, null);
		ball.draw(g);
		gaugebar.draw(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(per < 1 && per >= 0) {
				per += inde;
			}
			else {
				inde = -inde;
				per += inde;
			}
			gaugebar.setPer(per);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ball.getBody().setAwake(true);
			float dx = (float) ((ball.getBody().getPosition().x + 400 * per) - ball.getBody().getPosition().x);
			float dy = (float) ((ball.getBody().getPosition().y + 400 * per) - ball.getBody().getPosition().y);
			dx *= 100*per;
			dy *= 100*per;
			Vec2 launchVelocity = new Vec2(dx, dy);
			ball.getBody().setLinearVelocity(launchVelocity);
			
			per = 0.1f;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void beginContact(Contact contact) {
		ball.getBody().setAwake(false);
	}

	@Override
	public void endContact(Contact contact) {
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	}
}
