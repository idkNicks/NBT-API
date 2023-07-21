package io.github.nicks;

import io.github.nicks.version.VersionController;
import org.bukkit.plugin.java.JavaPlugin;

public class NBTApi extends JavaPlugin {

    @Override
    public void onEnable() {
        VersionController.initialize(this);
    }
}
