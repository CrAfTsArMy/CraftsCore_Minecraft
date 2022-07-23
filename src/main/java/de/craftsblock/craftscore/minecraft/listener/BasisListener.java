package de.craftsblock.craftscore.minecraft.listener;

import de.craftsblock.craftscore.minecraft.placeholder.PlaceholderManager;
import de.craftsblock.craftscore.minecraft.scoreboard.ScoreChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BasisListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onScoreChange(ScoreChangeEvent event) {
        event.setContent(PlaceholderManager.processString(event.getContent(), event.getPlayer()));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(PlaceholderManager.processString(event.getMessage(), event.getPlayer()));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSign(SignChangeEvent event) {
        String[] lines = event.getLines();
        for (int i = 0; i < lines.length; i++)
            event.setLine(i, PlaceholderManager.processString(lines[i], event.getPlayer()));
    }

}
