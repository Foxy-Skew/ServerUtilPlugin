package serverutils.serverutils;

import org.bukkit.plugin.java.JavaPlugin;
import serverutils.serverutils.Events.Events;
import serverutils.serverutils.Item.ItemManager;
import serverutils.serverutils.cmds.CommandHandler;
import java.awt.*;

public final class Serverutils extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(Color.CYAN + "ServerUtil has been enabled");
        getServer().getPluginManager().registerEvents(new Events(), this );
        getCommand("item").setExecutor(new CommandHandler());
        ItemManager.init();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
