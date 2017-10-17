package data;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class GameMap {
	private static GameMap map;
	
	private final BlockPlacementStrategy blockStrategy;
	
	public final int GENERATED_BLOCKS_MIN, GENERATED_BLOCKS_MAX;
	//How many blocks there should be along the width and the height of the screen
	public final int X_TILES, Y_TILES;
	
	
	private List<Block> blocks;
	private int currentDepth, generatedDepth, yOffset;
	
	private GameMap() {
		GENERATED_BLOCKS_MIN = 20;
		GENERATED_BLOCKS_MAX = 30;
		X_TILES = 6;
		Y_TILES = 14;
		blockStrategy = new RandomizedBlockPlacementStrategy();
		blocks = new ArrayList<Block>();
	}
	
	public static GameMap instance() {
		if (map == null) {
			map = new GameMap();
		}
		return map;
	}
	
	public void generateBlocks() {
		int levels = GENERATED_BLOCKS_MAX - generatedDepth + currentDepth;
		//Some complicated algorithm for generating appropriate maps:
		blockStrategy.addBlocks(blocks, levels, X_TILES, currentDepth);
		generatedDepth = currentDepth + GENERATED_BLOCKS_MAX;
	}
	
	public void doLogic() {
		if (generatedDepth - currentDepth < GENERATED_BLOCKS_MIN);
			generateBlocks();
	}
	
	public void draw(Graphics g) {
		for (Block b : blocks) {
			b.draw(g, yOffset);
		}
	}
	
}
