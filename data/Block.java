package data;

import java.awt.image.*;

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
}
