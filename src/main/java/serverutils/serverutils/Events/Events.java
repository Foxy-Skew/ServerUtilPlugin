package serverutils.serverutils.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;
import serverutils.serverutils.Item.ItemManager;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        player.getInventory().addItem(ItemManager.tool);

    }

    @EventHandler
    public void itemUse(PlayerInteractEvent e) {
        if (e.getAction().isRightClick()) {
            Player player = e.getPlayer();
            int item = player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
            int meta = ItemManager.tool.getItemMeta().getCustomModelData();
            if (item == meta) {
                Vector dir = player.getLocation().getDirection();
                player.setVelocity(dir.multiply(10000));
            }
        }
        return;
    }
}
