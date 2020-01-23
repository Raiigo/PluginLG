package fr.raiigo.lguhc.utils.config;

import fr.raiigo.lguhc.Main;

import java.util.ArrayList;

public class ConfigHandler {

    private ArrayList<Config> configList = new ArrayList<Config>();
    private Main main;

    public ConfigHandler(Main main) {
        setMain(main);
    }

    public void addConfig(Config config) {
        configList.add(config);
    }

    public void clearConfig() {

        if(!configList.isEmpty()) {
            configList.clear();
        }

    }

    public Config getConfig(String name) {
        for (int i = 0; i < configList.size(); i++) {
            if (configList.get(i).getName().equals(name)) {
                return configList.get(i);
            }
        }
        return null;
    }

    private void setMain(Main main) {
        this.main = main;
    }

    private Main getMain() {
        return this.main;
    }

}
