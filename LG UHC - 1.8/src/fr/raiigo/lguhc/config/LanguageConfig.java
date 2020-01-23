package fr.raiigo.lguhc.config;

import fr.raiigo.lguhc.Main;
import fr.raiigo.lguhc.utils.config.Config;
import org.bukkit.configuration.file.FileConfiguration;

public class LanguageConfig extends Config {
    public LanguageConfig(Main main, String name) {
        super(main, name);
    }

    @Override
    public void onCreated(FileConfiguration config) {

        config.set("commands.lg.discord.message", "&l&8[&3Discord&8] &r&fVoici le Discord officiel");
        config.set("commands.lg.discord.link", "https://discord.gg/ajv8Jxv");

        config.set("commands.lg.config.init", "&l&8[&6LG UHC&8] &r&fL'initialisation est terminee");
        config.set("commands.lg.config.reload", "&l&8[&6LG UHC&8] &r&fLe reload est termine");

        config.set("commands.lg.error", "&l&8[&4Error&8] &r&fVous devez etre un joueur pour executer cette commande");

        config.set("commands.lg.party.add.success", "&l&8[&bParty&8] &r&fLe joueur &l&5%player% &r&fa ete ajoute a la partie");
        config.set("commands.lg.party.add.inparty", "&l&8[&4Error&8] &r&fJe joueur &l&5%player% &r&fest deja dans la partie");
        config.set("commands.lg.party.add.offline", "&l&8[&4Error&8] &r&fJe joueur &l&5%player% &r&fn'est pas connecte");

        config.set("commands.lg.party.kick.success", "&l&8[&bParty&8] &r&fLe joueur &l&5%player% &r&fa ete supprime a la partie");
        config.set("commands.lg.party.kick.notinparty", "&l&8[&4Error&8] &r&fJe joueur &l&5%player% &r&fn'est pas dans la partie");

    }
}
