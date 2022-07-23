package de.craftsblock.craftscore.minecraft;

import de.craftsblock.craftscore.minecraft.listener.BasisListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Minecraft {

    private Plugin plugin;

    public void init(Plugin plugin) {
        try {
            Class.forName("org.bukkit");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new BasisListener(), plugin);
    }

    public Plugin plugin() {
        return plugin;
    }

    private static Minecraft minecraft;

    public static Minecraft instance() {
        if (minecraft == null)
            minecraft = new Minecraft();
        return minecraft;
    }

}
