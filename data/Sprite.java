package data;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Sprite extends Entity implements Controllable{
	
	private Movement m;

	public Sprite(int x, int y, int width, int height, BufferedImage image) {
		super(x, y, width, height, image);
	}
	
	public void processMovement(Movement m) {
		
	}
	
	public void move() {
		int newX = x + m.xDirection, newY = y + m.yDirection;
	}
}
