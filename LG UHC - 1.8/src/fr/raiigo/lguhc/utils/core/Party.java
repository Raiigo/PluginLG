package fr.raiigo.lguhc.utils.core;

import fr.raiigo.lguhc.Main;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Party {

    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Main main;

    public Party(Main main) {
        this.main = main;
    }

    public void addPlayer(Player player, Player executor) {
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).equals(player)) {
                executor.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.add.inparty").replaceAll("&", "§").replaceAll("%player%", player.getDisplayName()));
                return;
            }
        }
        if(player.isOnline()) {
            playerList.add(player);
            executor.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.add.success").replaceAll("&", "§").replaceAll("%player%", player.getDisplayName()));
        } else {
            executor.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.add.offline").replaceAll("&", "§").replaceAll("%player%", player.getDisplayName()));
        }

    }

    public void removePlayer(String name, Player executor) {
        for (int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).getName().equalsIgnoreCase(name)) {
                playerList.remove(playerList.get(i));
                executor.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.kick.success").replaceAll("&", "§").replaceAll("%player%", name));
                return;
            }
        }
        executor.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.party.kick.notinparty").replaceAll("&", "§").replaceAll("%player%", name));
    }

    public void sendList(Player executor) {
        executor.sendMessage("");
    }

}
