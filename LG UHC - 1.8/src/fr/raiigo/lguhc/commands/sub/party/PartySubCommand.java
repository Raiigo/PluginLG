package fr.raiigo.lguhc.commands.sub.party;

import fr.raiigo.lguhc.Main;
import fr.raiigo.lguhc.utils.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PartySubCommand extends SubCommand {

    private Main main;

    public PartySubCommand(String name, Main main) {
        super(name);
        this.main = main;
    }

    @Override
    public void onExecuted(Player player, String[] args) {

        switch (args[1]) {

            case "add":
                if(Bukkit.getPlayer(args[2]) != null) {
                    this.main.game.getParty().addPlayer(Bukkit.getPlayer(args[2]), player);
                } else {
                    player.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.add.offline").replaceAll("&", "§").replaceAll("%player%", args[2]));
                }
                break;

            case "kick":

                this.main.game.getParty().removePlayer(args[2], player);

                break;

        }

    }
}
