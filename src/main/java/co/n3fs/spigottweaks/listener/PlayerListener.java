package co.n3fs.spigottweaks.listener;

import co.n3fs.spigottweaks.N3FSTweaks;
import co.n3fs.spigottweaks.util.BlockUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;

/**
 * Listener for player events
 *
 * Created by md678685 on 24/08/2016.
 */
public class PlayerListener implements Listener {

    private final N3FSTweaks plugin;

    public PlayerListener(N3FSTweaks _plugin) {
        this.plugin = _plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (event.getClickedBlock().getType().equals(Material.REDSTONE_ORE)) {
            Collection<Block> redstoneOreBlocks = BlockUtils.getNearbyMatchingBlocks(event.getClickedBlock());
            for (Block block : redstoneOreBlocks) {
                block.setType(Material.GLOWING_REDSTONE_ORE);
            }
        }
    }

}
