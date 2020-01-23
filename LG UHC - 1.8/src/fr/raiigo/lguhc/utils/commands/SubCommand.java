package fr.raiigo.lguhc.utils.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand implements SubCommandEvent {

    private String name;

    public SubCommand(String name) {
        setName(name);
    }

    public void execute(Player player, String[] args) {
        onExecuted(player, args);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
