package me.nightfoxie;

import me.nightfoxie.commands.Wled;
import org.bukkit.plugin.java.JavaPlugin;

public class WledIntegration extends JavaPlugin {
    @Override
    public void onEnable() {
        if (this.getCommand("wled") != null) {
            this.getCommand("wled").setExecutor(new Wled());
            this.getCommand("wled").setTabCompleter(new Wled());
            System.out.println("Successfully started.");
        } else {
            System.out.println("Error: Command 'wled' not found in plugin.yml.");
            System.out.println("It means that this plugin is corrupted as the given command is not registered.");
            System.out.println("If you think it's a mistake, contact me at Telegram/Instagram: @nightfoxie");
        }



    }

    @Override
    public void onDisable() {
        System.out.println("Plugin is shutting down. See ya next time :)");
    }
}
