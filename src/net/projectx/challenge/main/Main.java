package net.projectx.challenge.main;

import net.projectx.api.main.PXAPI;
import net.projectx.challenge.functions.commands.cmd_timer;
import org.bukkit.plugin.java.JavaPlugin;

import static net.projectx.api.main.Data.prefix;

/**
 * ~Yannick on 27.10.2019 at 17:31 o´ clock
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println(prefix + "Challenge wurde geladen!");
        registerCommands();
    }

    @Override
    public void onDisable() {
        System.out.println(prefix + "Challenge wurde gestoppt!");
    }

    public void registerCommands() {
        PXAPI.register(new cmd_timer(), this);
    }
}
