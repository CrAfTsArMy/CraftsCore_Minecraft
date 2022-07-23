package de.craftsblock.craftscore.minecraft.placeholder;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class PlaceholderManager {

    private static ConcurrentHashMap<String, AbstractPlaceholder> placeholder;

    public static void register(AbstractPlaceholder placeholder) {
        if (!isRegistered(placeholder))
            PlaceholderManager.placeholder.put(placeholder.identifier().replace("%", "").replace(" ", "_").trim().toLowerCase(), placeholder);
    }

    public static void unregister(AbstractPlaceholder placeholder) {
        if (isRegistered(placeholder))
            PlaceholderManager.placeholder.remove(placeholder.identifier().replace("%", "").replace(" ", "_").trim().toLowerCase());
    }

    public static boolean isRegistered(AbstractPlaceholder placeholder) {
        return isRegistered(placeholder.identifier());
    }

    public static boolean isRegistered(String identifier) {
        identifier = identifier.replace("%", "").replace(" ", "_").trim().toLowerCase();
        return !PlaceholderManager.placeholder.isEmpty() && PlaceholderManager.placeholder.containsKey(identifier);
    }

    @Nullable
    public static AbstractPlaceholder search(String identifier) {
        identifier = identifier.replace("%", "").replace(" ", "_").trim().toLowerCase();
        if (isRegistered(identifier))
            return placeholder.get(identifier);
        return null;
    }

    public static String processString(String content, Player player) {
        String[] stripped = content.split("%");
        for (int i = 0; i < stripped.length; i++)
            if (search(stripped[i]) != null)
                stripped[i] = Objects.requireNonNull(search(stripped[i])).request(player);
        StringBuilder message = new StringBuilder();
        for (String s : stripped)
            message.append(s);
        return message.toString();
    }

}
