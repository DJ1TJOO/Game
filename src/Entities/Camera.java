package Entities;


import Main.Game;

public class Camera {

	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(Entity object) {
		
		x += ((object.getX() - x) - Game.PIX_WIDTH/2) * 0.05f;
		y += ((object.getY() - y) - Game.PIX_HEIGHT/2) * 0.05f;

		/*if(x <= 32) x = 32;
		if(x >= 1048 - 32) x = 1048 - 32;
		if(y <= 32) y = 32;
		if(y >= 746) y = 746;*/
		
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
