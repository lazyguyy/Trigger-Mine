package data;

import java.awt.image.*;
import java.awt.*;

public class Block extends Entity{
    private BlockType type;
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
    
    public void draw(Graphics g, int yOffset) {
    	super.draw(g, yOffset);
    	g.setColor(Color.black);
    	g.drawString(String.valueOf(type), x + 2, y + BLOCK_WIDTH/2 - 4);
    }
}
