package scene;

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;

public abstract class GolfAppScene extends JLayeredPane implements KeyListener {
	protected SceneManagement sm;
	
	public GolfAppScene() {
		super();
		setLayout(null);
		super.setPreferredSize(new Dimension(800, 600));
		addKeyListener(this);
		requestFocus();
	}
	
	public GolfAppScene(SceneManagement sm) {
		this();
		this.sm = sm;
	}
	
	public abstract void update(double delta);
}


