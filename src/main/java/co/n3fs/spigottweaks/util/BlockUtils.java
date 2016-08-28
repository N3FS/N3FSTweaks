package co.n3fs.spigottweaks.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Collection;
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
     *
     * @param block Block to get nearby blocks
     * @return
     */
    public static Collection<Block> getNearbyMatchingBlocks(Block block) {
        HashSet<BlockFace> faces = new HashSet<BlockFace>();
        faces.add(BlockFace.UP);
        faces.add(BlockFace.DOWN);
        faces.add(BlockFace.NORTH);
        faces.add(BlockFace.SOUTH);
        faces.add(BlockFace.EAST);
        faces.add(BlockFace.WEST);
        faces.add(BlockFace.NORTH_EAST);
        faces.add(BlockFace.NORTH_WEST);
        faces.add(BlockFace.SOUTH_EAST);
        faces.add(BlockFace.SOUTH_WEST);
        return getNearbyBlocksOfMaterial(block, block.getType(), faces);
    }

    /**
     * Add all nearby blocks of a specified material to a given Collection. It's recommended that you don't use this
     * for blocks which are likely to be near many (or an infinite number of) other blocks of the specified material
     * (ie dirt).
     *
     * @param block Block to get nearby blocks
     * @param material Material which blocks must be
     * @param faces Faces to check
     * @return
     */
    public static Collection<Block> getNearbyBlocksOfMaterial(Block block, Material material, Collection<BlockFace> faces) {
        HashSet<Block> blocks = new HashSet<>();
        return addNearbyBlocksOfMaterial(blocks, block, material, faces);
    }

    /**
     * Add all nearby blocks of a specified material to a given Collection. It's recommended that you don't use this
     * for blocks which are likely to be near many (or an infinite number of) other blocks of the specified material
     * (ie dirt).
     *
     * @param blocks Collection to add to
     * @param block Block to get nearby blocks
     * @param material Material which blocks must be
     * @param faces Faces to check
     * @return The resulting collection
     */
    public static Collection<Block> addNearbyBlocksOfMaterial(Collection<Block> blocks, Block block, Material material, Collection<BlockFace> faces) {
        Block nextBlock;
        for (BlockFace face : faces) {
            nextBlock = block.getRelative(face);
            if (blocks.contains(nextBlock)) continue;
            if (nextBlock.getType().equals(material)) {
                if (blocks.add(nextBlock)) {
                    addNearbyBlocksOfMaterial(blocks, nextBlock, material, faces);
                }
            }
        }
        return blocks;
    }

}
