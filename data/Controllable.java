package data;

public interface Controllable {
	public void processMovement(Movement m);
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
}
