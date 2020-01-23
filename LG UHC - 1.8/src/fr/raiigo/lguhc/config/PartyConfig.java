package fr.raiigo.lguhc.config;

import fr.raiigo.lguhc.Main;
import fr.raiigo.lguhc.utils.config.Config;
import org.bukkit.configuration.file.FileConfiguration;

public class PartyConfig extends Config {

    public PartyConfig(Main main, String name) {
        super(main, name);
    }

    @Override
    public void onCreated(FileConfiguration config) {
        config.set("border.center.x", 0);
        config.set("border.center.z", 0);
        config.set("border.side", 100);
    }

}
