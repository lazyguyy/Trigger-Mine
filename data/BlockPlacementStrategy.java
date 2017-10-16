package data;

import java.util.*;

public abstract class BlockPlacementStrategy {
	public abstract void addBlocks(List<Block> blocks, int levels, int xTiles);
}
