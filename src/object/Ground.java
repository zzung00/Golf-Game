package object;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Ground {
	private Body ground;
	private BodyDef groundbody = new BodyDef();
	private EdgeShape groundedge = new EdgeShape();
	private FixtureDef groundfixturedef = new FixtureDef(); 
	
	public Ground(World world) {
		groundbody.position.set(0, 0);
		groundbody.setType(BodyType.STATIC);
		ground = world.createBody(groundbody);
		groundedge.set(new Vec2(0, 530),new Vec2(2000, 530));
		groundfixturedef.shape = groundedge;
		groundfixturedef.density = 1.0f;
		groundfixturedef.friction = 1.0f;
		groundfixturedef.restitution = 0.2f;
		ground.createFixture(groundfixturedef);
	}
	
	public Body getBody() {
		return ground;
	}
	
}
