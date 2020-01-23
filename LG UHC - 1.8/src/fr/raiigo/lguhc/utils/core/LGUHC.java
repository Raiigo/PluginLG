package fr.raiigo.lguhc.utils.core;

// Prediction : cette class va être immense

import fr.raiigo.lguhc.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class LGUHC {

    private Main main;
    private Party party;

    public LGUHC(Main main) {
        this.main = main;
        this.party = new Party(this.main);
    }

    public Party getParty() {
        return this.party;
    }

}
