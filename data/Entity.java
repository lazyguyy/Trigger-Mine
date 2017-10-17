package data;

import java.awt.image.*;
import java.awt.*;

public abstract class Entity {
    
    protected final static int BLOCK_WIDTH = 100;
    
    protected int x, y;
    protected int width, height;
    protected BufferedImage image;
    protected Rectangle rect;
    
    public Entity(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.rect = new Rectangle(x, y, width, height);
    }
    
    public void draw(Graphics g, int yOffset) {
        if (image == null) {
            g.setColor(Color.yellow);
            g.fillRect(x, y - yOffset, width, height);
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public Rectangle getRectangle(){
        return rect;
    }
    
    public boolean intersects(Entity e) {
        return rect.intersects(e.getRectangle());
    }
}
