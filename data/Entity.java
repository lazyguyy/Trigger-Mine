package data;

import java.awt.image.*;

public abstract class Entity {
    protected int x, y;
    protected int width, height;
    protected BufferedImage image;
    
    public Entity(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
}
