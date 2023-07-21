package io.github.nicks.version;

import io.github.nicks.exception.UnsupportedBukkitVersionException;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class VersionController {

    @Getter
    private static final VersionController INSTANCE = new VersionController();

    @Getter
    @Setter
    private Version version;

    private static JavaPlugin plugin;

    private VersionController() {}

    public static void initialize(JavaPlugin givenPlugin) {
        plugin = givenPlugin;
        INSTANCE.setVersion(determineVersion(plugin.getServer()));
    }

    private static Version determineVersion(Server server) {
        String bukkitVersion = server.getBukkitVersion().replace("-SNAPSHOT", "");
        return Arrays.stream(Version.values())
                .filter(it -> it.matches(bukkitVersion))
                .findFirst()
                .orElseThrow(() -> new UnsupportedBukkitVersionException(server.getVersion()));
    }
}
