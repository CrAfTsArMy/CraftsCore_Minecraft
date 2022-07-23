package de.craftsblock.craftscore.minecraft.placeholder;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPlaceholder {

    public abstract String identifier();

    @NotNull
    public abstract String request(@Nullable Player requester);

}
