package de.craftsblock.craftscore.minecraft.scoreboard;

import de.craftsarmy.craftscore.buildin.animate.Animator;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Score {

    private String content;
    private Animator<String> animator;

    private final boolean animated;
    private Team animationTarget;
    private final StringBuilder identifier = new StringBuilder();

    public Score(String content) {
        this.content = content;
        this.animated = false;
    }

    public Score(Animator<String> stringAnimator) {
        this.animator = stringAnimator;
        this.animated = true;
        String[] tiles = UUID.randomUUID().toString().split("");
        for (String tile : tiles)
            this.identifier.append("§").append(tile);
    }

    @Nullable
    public String content() {
        return content;
    }

    public void setTarget(Team animationTarget) {
        this.animationTarget = animationTarget;
    }

    @Nullable
    public Team target() {
        return animationTarget;
    }

    public boolean animated() {
        return animated;
    }

    @Nullable
    public Animator<String> animator() {
        return animator;
    }

    @Nullable
    public String identifier() {
        return identifier.toString();
    }

}
