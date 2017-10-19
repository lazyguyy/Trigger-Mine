package data;

import java.awt.image.BufferedImage;
import java.awt.*;

public class Sprite extends Entity implements Controllable{
	
	private Movement m;
	private GameMap gm;
	
	public Sprite(int x, int y, int width, int height, BufferedImage image) {
		super(x, y, width, height, image);
		gm = GameMap.instance();
	}
	
	public void processMovement(Movement m) {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void move() {
		int newX = x + m.xDirection, newY = y + m.yDirection;
		if (!(gm.isOccupied(newX, newY) || gm.isOccupied(newX + width, newY)
		   || gm.isOccupied(newX, newY + height) || gm.isOccupied(newX + width, newY + height))) {
			x = newX;
			y = newY;
		}
		else {
			
		}
	}
}
