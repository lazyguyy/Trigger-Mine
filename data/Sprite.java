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
	
	/*
	 * takes a Movement-object and processes it, so the sprite can try and move.
	 * @see data.Controllable#processMovement(data.Movement)
	 */
	public void processMovement(Movement m) {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	//Check whether the suggested movement is allowed and then move.
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
