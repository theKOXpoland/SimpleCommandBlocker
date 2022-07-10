package mc.theKOXpoland.SimpleCommandBlocker;

import mc.theKOXpoland.SimpleCommandBlocker.Events.CommandBlocker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainFile extends JavaPlugin  {

    private boolean ColonBlocked;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getConfig();

        Bukkit.getPluginManager().registerEvents(new CommandBlocker(this), this);

        ColonBlocked = getConfig().getBoolean("blockcolon");

        Bukkit.getLogger().info("SimpleCommandBlocker - Activated!");
    }

    public boolean isColonBlocked() {
        return this.ColonBlocked;
    }
}
