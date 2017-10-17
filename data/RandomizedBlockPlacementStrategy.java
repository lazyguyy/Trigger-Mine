package data;

import java.util.List;

public class RandomizedBlockPlacementStrategy extends BlockPlacementStrategy{
	BlockType[] blockTypes = BlockType.values();
	
	
	@Override
	public void addBlocks(List<Block> blocks, int levels, int xTiles, int depth) {
		for (int y = 0; y < levels; y++) {
			for (int x = 0; x < xTiles; x++) {
				int choice = (int)(Math.random() * (blockTypes.length));
				if (choice != blockTypes.length) {
					blocks.add(new Block(x * Entity.BLOCK_WIDTH, (depth + y) * Entity.BLOCK_WIDTH, null, blockTypes[choice]));
				}
			}
		}
	}

}
