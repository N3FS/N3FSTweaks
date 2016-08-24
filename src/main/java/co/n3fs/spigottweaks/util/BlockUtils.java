package co.n3fs.spigottweaks.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.HashSet;

/**
 * Miscellaneous block-related utility functions
 *
 * Created by md678685 on 24/08/2016.
 */
public class BlockUtils {

    /**
     * Get all nearby blocks of the same material. It's recommended that you don't use this for blocks which are likely
     * to be near many (or an infinite number of) other blocks of the same material.
     * @param block
     * @return
     */
    public static HashSet<Block> getNearbyMatchingBlocks(Block block) {
        return getNearbyBlocksOfMaterial(block, block.getType());
    }

    /**
     * Get all nearby blocks of a specified material. It's recommended that you don't use this for blocks which are
     * likely to be near many (or an infinite number of) other blocks of the specified material (ie dirt).
     *
     * @param block
     * @param material
     * @return
     */
    public static HashSet<Block> getNearbyBlocksOfMaterial(Block block, Material material) {
        HashSet<Block> blocks = new HashSet<Block>();
        blocks.add(block);

        Block nextBlock;

        for (BlockFace face : BlockFace.values()) {
            nextBlock = block.getRelative(face);
            if (nextBlock.getType().equals(material) && !blocks.contains(nextBlock)) {
                blocks.add(nextBlock);
                getNearbyBlocksOfMaterial(nextBlock, material);
            }
        }

        return blocks;
    }

}
