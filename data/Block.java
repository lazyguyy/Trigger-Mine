package data;

import java.awt.image.*;
import java.awt.*;

public class Block extends Entity{

    protected final static int BLOCK_WIDTH = 100;
    private BlockType type;
    private int miningStatus;
    private boolean destroy;
    
    public Block(int x, int y, BufferedImage image, BlockType type) {
        super(x, y, BLOCK_WIDTH, BLOCK_WIDTH, image);
        this.type = type;
    }
    
    public BlockType getBlockType() {
        return type;
    }
    
    public int getValue() {
        return type.getValue();
    }
    
    public boolean toDestroy() {
    	return destroy;
    }
    
    public void draw(Graphics g, int yOffset) {
    	super.draw(g, yOffset);
    	g.setColor(Color.black);
    	g.drawString(String.valueOf(type), x + 2, y + BLOCK_WIDTH/2 - 4);
    }
    
    public void mine() {
    	miningStatus++;
    	if (miningStatus > Math.sqrt(type.getValue())) {
    		destroy = true;
    	}
    }
}
