package serverutils.serverutils.cmds;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.util.RGBLike;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import serverutils.serverutils.SubCommand;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Create extends SubCommand {
    @Override
    public String getName() { return "create"; }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return null;
    }

    @Override
    public void perform(Player player, String[] args) {
        try {
            ItemStack item = new ItemStack(Material.valueOf(args[1]));
            Hashtable<String, String> colors = new Hashtable<String, String>();

            colors.put("RED", "#61001b");
            colors.put("WHITE", "#FFFFFF");
            colors.put("YELLOW", "#e0ff00");
            colors.put("PURPLE", "#402060");
            colors.put("GREEN", "#a4cb80");
            colors.put("BLUE", "#0f6180");
            colors.put("PINK", "#bc066a");

            ItemMeta meta = item.getItemMeta();
            meta.displayName(Component.text(args[2], TextColor.fromHexString(colors.get(args[3])), TextDecoration.valueOf(args[4])));
            meta.setUnbreakable(Boolean.parseBoolean(args[7]));
            meta.setCustomModelData(Integer.valueOf(args[6]));
            meta.addItemFlags(ItemFlag.valueOf(args[5]));
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
        } catch (IllegalArgumentException e) {
            player.sendMessage("failed flag");
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        switch (args.length) {
            case 1:
                List<String> mainTabs = new ArrayList<>();
                mainTabs.add("create");
                return mainTabs;
            case 2:
                List<String> materialNames = Arrays.stream(Material.values())
                    .map(Material::name)
                    .collect(Collectors.toList());
                return materialNames;
            case 4:
                List<String> clrs = Arrays.stream(BossBar.Color.values())
                        .map(BossBar.Color::name)
                        .collect(Collectors.toList());
                return clrs;

            case 5:
                List<String> decoration = Arrays.stream(TextDecoration.values())
                    .map(TextDecoration::name)
                    .collect(Collectors.toList());
                return decoration;
            case 6:
                List<String> flags = Arrays.stream(ItemFlag.values())
                    .map(ItemFlag::name)
                    .collect(Collectors.toList());
                return flags;
            case 8:
                List<String> bool = new ArrayList<>();
                bool.add("true");
                bool.add("false");
                return bool;
        }
        return null;
    }
}
