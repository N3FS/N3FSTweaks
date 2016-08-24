package co.n3fs.spigottweaks;

import co.n3fs.spigottweaks.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class N3FSTweaks extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    @Override
    public void onDisable() {
        
    }

}
