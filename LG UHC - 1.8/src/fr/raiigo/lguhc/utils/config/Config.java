package fr.raiigo.lguhc.utils.config;

import fr.raiigo.lguhc.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public abstract class Config implements ConfigCreate {

    private Main main;
    private String name;
    private FileConfiguration config;

    private boolean existing;

    public Config(Main main, String name) {

        setMain(main);
        setName(name);

        File configFile = new File(main.getDataFolder() + File.separator + name + ".yml");

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                existing = false;
                System.out.println("Le fichier de config n'a pas ete trouve et donc cree");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            existing = true;
            System.out.println("Le fichier de config a ete trouve");

        }

        setConfigFile(YamlConfiguration.loadConfiguration(configFile));

        System.out.println("from config x: " + config.getInt("border.center.x"));
        System.out.println("from config z: " + config.getInt("border.center.z"));

        if (!existing) {
            onCreated(getConfigFile());
        }

        try {
            getConfigFile().save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setMain(Main main) {
        this.main = main;
    }

    private Main getMain() {
        return this.main;
    }

    public FileConfiguration getConfigFile() {
        return this.config;
    }

    private void setConfigFile(FileConfiguration config) {
        this.config = config;
    }

}
