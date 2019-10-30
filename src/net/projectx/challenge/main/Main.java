package net.projectx.challenge.main;

import net.projectx.api.main.PXAPI;
import net.projectx.challenge.functions.ChallengeListener;
import net.projectx.challenge.functions.Scheduler;
import net.projectx.challenge.functions.commands.cmd_firework;
import net.projectx.challenge.functions.commands.cmd_settings;
import net.projectx.challenge.functions.commands.cmd_timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static net.projectx.api.main.Data.prefix;

/**
 * ~Yannick on 27.10.2019 at 17:31 o´ clock
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Data.instance = this;
        System.out.println(prefix + "Challenge wurde geladen!");
        registerCommands();
        Scheduler.startScheduler();
        registerListener();
    }

    @Override
    public void onDisable() {
        System.out.println(prefix + "Challenge wurde gestoppt!");
        Scheduler.stopScheduler();
        Data.timerrunning = false;
    }

    public void registerCommands() {
        PXAPI.register(new cmd_timer(), this);
        PXAPI.register(new cmd_firework(), this);
        PXAPI.register(new cmd_settings(), this);
    }

    public void registerListener(){
        Bukkit.getPluginManager().registerEvents(new ChallengeListener(), this);
    }
}
