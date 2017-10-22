package data;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class GameMap {
	//Singleton pattern cause we're cool.
	private static GameMap map;
	
	//Strategy-pattern for block placement, because it makes it easy to implement a rudimentary way for placing blocks.
	private final BlockPlacementStrategy blockStrategy;
	
	//How many lines blocks should be generated at least and at max.
	public final int GENERATED_BLOCKS_MIN, GENERATED_BLOCKS_MAX;
	//How many blocks there should be along the width and the height of the screen
	public final int X_TILES, Y_TILES;
	
	//Holds a list of all currently active blocks.
	private List<Block> blocks;
	
	//The depth of the player, the depth blocks have  been generated to and the resulting yOffset.
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
	
	/*
	 * Handles all logical interaction between blocks and the player. 
	 */
	public void doLogic() {
		//Generate new blocks if needed.
		if (generatedDepth - currentDepth < GENERATED_BLOCKS_MIN);
			generateBlocks();
		//Delete destroyed blocks.
		for (int i = blocks.size() - 1; i >= 0; i--) {
			if (blocks.get(i).toDestroy()) {
				blocks.remove(i);
			}
		}
	}
	
	/*
	 * Implements the means of drawing the current map and the player on the screen.
	 */
	public void draw(Graphics g) {
		for (Block b : blocks) {
			b.draw(g, yOffset);
		}
	}
	
	/*
	 * Looks for a Block that covers the point (x, y).
	 * Returns null if no such block exists.
	 */
	private Block getBlockAt(int x, int y) {
		int start = 0, end = blocks.size();
		while (end - start >= 1) {
			int mid = (end - start) / 2;
			Block b = blocks.get(mid);
			if (b.getX() > x || b.getY() > y) {
				end = mid;
			}
			if (b.getX() + b.getWidth() < x || b.getY() + b.getHeight() < y) {
				start = mid + 1;
			}
			else {
				return null;
			}
		}
		Block b = blocks.get(start);
		return b.getX() <= x && x <= b.getX() + b.getHeight() && b.getY() <= y && y <= b.getY() + b.getHeight() ? b : null;
	}
	
	/*
	 * Tests, whether a specified position is occupied by a block.
	 */
	public boolean isOccupied(int x, int y) {
		return getBlockAt(x, y) == null ? false : true;
	}
}
