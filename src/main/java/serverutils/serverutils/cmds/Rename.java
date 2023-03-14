package serverutils.serverutils.cmds;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import serverutils.serverutils.SubCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Rename extends SubCommand {
    @Override
    public String getName() { return "rename"; }

    @Override
    public String getDescription() { return null; }

    @Override
    public String getSyntax() { return null; }

    @Override
    public void perform(Player player, String[] args) {
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        Hashtable<String, String> colors = new Hashtable<String, String>();

        colors.put("RED", "#61001b");
        colors.put("WHITE", "#FFFFFF");
        colors.put("YELLOW", "#e0ff00");
        colors.put("PURPLE", "#402060");
        colors.put("GREEN", "#a4cb80");
        colors.put("BLUE", "#0f6180");
        colors.put("PINK", "#bc066a");

        try {
            meta.displayName(Component.text(args[1], TextColor.fromHexString(colors.get(args[2])), TextDecoration.valueOf(args[3])));
            item.setItemMeta(meta);
        } catch (Exception e) {
            player.sendMessage("cool you broke it");
        }

    }
    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        switch (args.length) {
            case 3:
                List<String> clrs = Arrays.stream(BossBar.Color.values())
                        .map(BossBar.Color::name)
                        .collect(Collectors.toList());
                return clrs;
            case 4:
                List<String> decorations = Arrays.stream(TextDecoration.values())
                        .map(TextDecoration::name)
                        .collect(Collectors.toList());
                return decorations;
        }
        return null;
    }
}
