package fr.raiigo.lguhc.commands;

import fr.raiigo.lguhc.Main;
import fr.raiigo.lguhc.commands.sub.config.ConfigSubCommand;
import fr.raiigo.lguhc.commands.sub.party.PartySubCommand;
import fr.raiigo.lguhc.utils.commands.CommandHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LGCommand implements CommandExecutor {

    private CommandHandler commandHandler;
    private Main main;

    public LGCommand(Main main) {
        this.main = main;
        commandHandler = new CommandHandler();
        commandHandler.addSubCommand(new ConfigSubCommand("config", this.main));
        commandHandler.addSubCommand(new PartySubCommand("party", this.main));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {



        if (sender instanceof Player) {

            Player player = (Player) sender;

            switch (args[0]) {

                case "discord":
                    player.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.discord.message").replaceAll("&", "§"));
                    player.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.discord.link").replaceAll("&", "§"));
                    break;

                case "config":
                    commandHandler.executeSubCommand("config", player, args);
                    break;

                case "party":
                    commandHandler.executeSubCommand("party", player, args);
                    break;

            }

        } else {
            sender.sendMessage(this.main.configHandler.getConfig("language").getConfigFile().getString("commands.lg.error").replaceAll("&", "§"));
        }

        return false;
    }

}
