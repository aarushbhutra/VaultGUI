package me.anon695.vaultgui.GUI;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class VaultMaker implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("vault")) {
            //Check if sender is a player
            if(!(sender instanceof Player)) {
                sender.sendMessage("You must be a player to use this command!");
            } else {
                ItemStack gray = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                Player player = (Player) sender;
                StorageGui gui = Gui.storage()
                        .title(Component.text(player.getDisplayName() + "'s Vault"))
                        .rows(6)
                        .create();
                GuiItem guiItem = ItemBuilder.from(Material.DIAMOND).name(Component.text("Close", NamedTextColor.RED)).lore(Component.text("Click To Close", NamedTextColor.RED)).asGuiItem(event -> {
                    gui.close(player);
                });
                GuiItem close = ItemBuilder.from(gray).name(Component.text("")) .asGuiItem();
                gui.setCloseGuiAction(event -> {
                    player.sendMessage("[Vault] Saving your vault...");
                    gui.update();
                    player.sendMessage("[Vault] Vault saved!");
                });
                gui.getFiller().fillBetweenPoints(6,1,6,4,close);
                gui.getFiller().fillBetweenPoints(6,6,6,9,close);
                gui.disableItemTake();
                gui.disableItemSwap();
                gui.disableItemDrop();
                gui.disableOtherActions();
                gui.setItem(49, guiItem);
                gui.open(player);
            }
        }
        return true;
    }
}
