package fr.raiigo.lguhc.commands.sub.config;

import fr.raiigo.lguhc.Main;
import fr.raiigo.lguhc.utils.commands.SubCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ConfigSubCommand extends SubCommand {

    private Main main;

    public ConfigSubCommand(String name, Main main) {
        super(name);
        this.main = main;
    }

    @Override
    public void onExecuted(Player player, String[] args) {

        switch (args[1]) {

            case "init":

                main.getServer().getWorld("world").getWorldBorder().setCenter((double) this.main.configHandler.getConfig("party").getConfigFile().getDouble("border.center.x"), (double) this.main.configHandler.getConfig("party").getConfigFile().getDouble("border.center.z"));
                main.getServer().getWorld("world").getWorldBorder().setSize((double) this.main.configHandler.getConfig("party").getConfigFile().getDouble("border.side"));

                player.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.config.init").replaceAll("&", "§"));

                break;

            case "reload":

                main.reloadConfigFile();

                player.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.config.reload").replaceAll("&", "§"));

                break;

        }

    }

}
