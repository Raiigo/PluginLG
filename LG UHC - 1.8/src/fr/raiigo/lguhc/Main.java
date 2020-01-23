package fr.raiigo.lguhc;

import fr.raiigo.lguhc.commands.LGCommand;
import fr.raiigo.lguhc.config.LanguageConfig;
import fr.raiigo.lguhc.config.PartyConfig;
import fr.raiigo.lguhc.utils.config.ConfigHandler;
import fr.raiigo.lguhc.utils.core.LGUHC;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public ConfigHandler configHandler;
    public LGUHC game;

    @Override
    public void onEnable() {

        this.game = new LGUHC(this);

        this.configHandler = new ConfigHandler(this);

        reloadConfigFile();

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        System.out.println("Border x: " + configHandler.getConfig("party").getConfigFile().getInt("border.center.x"));
        System.out.println("Border z: " + configHandler.getConfig("party").getConfigFile().getInt("border.center.z"));

        System.out.println("[LG UHC] Le plugin a demarre");
        getCommand("lg").setExecutor(new LGCommand(this));



    }

    @Override
    public void onDisable() {
        System.out.println("[LG UHC] Le plugin s'est arrete");
    }


    public void reloadConfigFile() {

        this.configHandler.clearConfig();

        // List des config a ajouter
        this.configHandler.addConfig(new PartyConfig(this, "party"));
        this.configHandler.addConfig(new LanguageConfig(this, "language"));

        System.out.println("from main x: " + this.configHandler.getConfig("party").getConfigFile().getInt("border.center.x"));
        System.out.println("from main z: " + this.configHandler.getConfig("party").getConfigFile().getInt("border.center.z"));

    }

}
