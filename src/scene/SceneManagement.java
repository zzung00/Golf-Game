package scene;

import java.util.ArrayList;

import golfapp.GolfApp;

public class SceneManagement {
	private GolfApp app;
	private ArrayList<GolfAppScene> scenes = new ArrayList<>();
	private int now = 0;
	
	public SceneManagement (GolfApp app) {
		this.app = app;
		scenes.add(new TitleScene(this));
		scenes.add(new GameScene(this));
		scenes.add(new FinalScene(this));
	}
	
	public void changeScene(int num) {
		now = num;
		app.setContentPane(scenes.get(now));
		app.pack();
		scenes.get(now).requestFocus();
	}
	
	public void update(double delta) {
		scenes.get(now).update(delta);
	}
}
