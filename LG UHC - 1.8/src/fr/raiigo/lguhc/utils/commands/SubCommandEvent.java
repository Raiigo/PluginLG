package fr.raiigo.lguhc.utils.commands;

import org.bukkit.entity.Player;

public interface SubCommandEvent {

    void onExecuted(Player player, String[] args);

}
