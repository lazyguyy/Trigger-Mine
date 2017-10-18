package data;

import java.util.List;

public class RandomizedBlockPlacementStrategy extends BlockPlacementStrategy{
	BlockType[] blockTypes = BlockType.values();
	
	
	@Override
	public void addBlocks(List<Block> blocks, int levels, int xTiles, int depth) {
		for (int y = 0; y < levels; y++) {
			for (int x = 0; x < xTiles; x++) {
				int choice = (int)(Math.random() * (blockTypes.length + 4));
				if (choice < blockTypes.length) {
					blocks.add(new Block(x * Block.BLOCK_WIDTH, (depth + y) * Block.BLOCK_WIDTH, null, blockTypes[choice]));
				}
			}
		}
	}

}
