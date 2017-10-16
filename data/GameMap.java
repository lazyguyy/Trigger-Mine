package data;

import java.util.*;
public class GameMap {
	private static GameMap map;
	
	public final int GENERATED_BLOCKS_MIN, GENERATED_BLOCKS_MAX;
	//How many blocks there should be along the width and the height of the screen
	public final int X_TILES, Y_TILES;
	
	
	private List<Block> blocks;
	private int currentDepth, generatedDepth;
	
	private GameMap() {
		GENERATED_BLOCKS_MIN = 20;
		GENERATED_BLOCKS_MAX = 30;
		X_TILES = 6;
		Y_TILES = 14;
	}
	
	public GameMap instance() {
		if (map == null) {
			map = new GameMap();
		}
		return map;
	}
	
	public void generateBlocks() {
		int levels = GENERATED_BLOCKS_MIN - generatedDepth + currentDepth;
		for (int y = 0; y < levels; y++) {
			for (int x = 0; x < X_TILES; x++) {
				//Some complicated algorithm for generating appropriate maps:
			}
		}
	}
	
	private void update() {
		if (generatedDepth - currentDepth < GENERATED_BLOCKS_MIN);
			generateBlocks();
	}
	
}
