package mc.theKOXpoland.SimpleCommandBlocker;

import mc.theKOXpoland.SimpleCommandBlocker.Events.CommandBlocker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainFile extends JavaPlugin  {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private boolean ColonBlocked;
    private boolean reverseBlock;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getConfig();

        Bukkit.getPluginManager().registerEvents(new CommandBlocker(this), this);

        ColonBlocked = getConfig().getBoolean("blockcolon");
        reverseBlock = getConfig().getBoolean("reverseBlock");

        Bukkit.getLogger().info("[SimpleCommandBlocker]" + ANSI_GREEN + " Activated!" +  ANSI_RESET);
    }

    public boolean isColonBlocked() {
        return this.ColonBlocked;
    }

    public boolean isReversed() {
        return this.reverseBlock;
    }
}