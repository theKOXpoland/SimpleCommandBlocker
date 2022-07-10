package mc.theKOXpoland.SimpleCommandBlocker.Events;

import mc.theKOXpoland.SimpleCommandBlocker.MainFile;
import mc.theKOXpoland.SimpleCommandBlocker.Utils.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;
import java.util.Objects;

public class CommandBlocker implements Listener {

    MainFile plugin;
    public CommandBlocker(MainFile plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission(Objects.requireNonNull(plugin.getConfig().getString("bypass_permission")))) {
            return;
        }
        String command = event.getMessage();
        String[] array = command.split(" ");

        List<String> allowed_commands = plugin.getConfig().getStringList("blocked_commands");

        if (plugin.isColonBlocked()) {
            if (command.contains(":")) {
                player.sendMessage(Util.fix(Objects.requireNonNull(plugin.getConfig().getString("permission_message"))));
                event.setCancelled(true);
                return;
            }
        }

        if (allowed_commands.contains(array[0])) {
            player.sendMessage(Util.fix(Objects.requireNonNull(plugin.getConfig().getString("permission_message"))));
            event.setCancelled(true);
        }
    }
}