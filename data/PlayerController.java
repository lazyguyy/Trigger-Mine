package data;

import java.awt.event.MouseEvent;


public class PlayerController {
	private GameMap gm;
	private Controllable sprite;
	private int xTarget, yTarget;
	
	public void doLogic() {
	}
	
	public void mouseClick(MouseEvent m) {
		xTarget = m.getX() - m.getX() % Block.BLOCK_WIDTH;
		yTarget = m.getY() - m.getY() % Block.BLOCK_WIDTH;
	}
}
