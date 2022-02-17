package me.anon695.vaultgui;

import me.anon695.vaultgui.GUI.VaultMaker;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Tell the server command executor to register the VaultMaker command
        registerCommands();
        //Tell server commands have loaded
        getLogger().info("VaultGUI has commands loaded!");
        // Tell the console we have loaded
        getLogger().info("VaultGUI has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands() {
        getCommand("vault").setExecutor(new VaultMaker());
    }
}
