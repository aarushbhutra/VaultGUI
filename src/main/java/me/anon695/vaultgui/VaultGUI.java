package me.anon695.vaultgui;

import me.anon695.vaultgui.GUI.VaultMaker;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("vault").setExecutor(new VaultMaker());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
