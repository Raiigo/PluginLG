package fr.raiigo.lguhc.utils.commands;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandHandler {

    private ArrayList<SubCommand> subCommands = new ArrayList<SubCommand>();

    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

    public void executeSubCommand(String name, Player player, String[] args) {

        for (int i = 0; i < subCommands.size(); i++) {
            if (subCommands.get(i).getName().equals(name)) {
                subCommands.get(i).execute(player, args);
                return;
            }
        }

        System.out.println("[LG UHC] La commande " + name + " est introuvable");

    }

}
