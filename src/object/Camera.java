package object;

public class Camera {
	private int minX, minY, maxX, maxY;
	private int x, y;
	
	public Camera() {
		minX = 0;
		minY = 0;
		maxX = 1800;
		maxY = 0;
		x = 0;
		y = 0;
	}
	
	public float lerp(float v0, float v1, float t) {
		return v0 + t * (v1 - v0);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void update(Ball ball) {
		x = (int)lerp(x, ball.getBody().getPosition().x, 0.03f);
		y = (int)lerp(y, ball.getBody().getPosition().y - 500, 0.03f);
	}
}
