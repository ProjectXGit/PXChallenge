package net.projectx.challenge.functions;

import net.projectx.challenge.main.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.text.DecimalFormat;

import static net.projectx.api.main.Data.prefix;
import static net.projectx.challenge.main.Data.fireworks;


/**
 * Created by Yannick on 29.10.2019 with IntelliJ for PXCode.
 */
public class ChallengeListener implements Listener {
    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent e){
        if(Data.timerrunning) {
            if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)) {
                finish();
                Bukkit.broadcastMessage(prefix + "Der §2§lEnderdrache§7 wurde getötet!");

            }
        }
    }

    public static void finish(){
        Data.timerrunning = false;
        DecimalFormat format = new DecimalFormat("00");
        long t = Data.timer;
        int hours = (int) t/(60*60*20);
        t = t % (60*60*20);
        int minutes = (int) t/(60*20);
        t = t % (60*20);
        int seconds = (int) t/(20);
        t = t % (20);
        int milliseconds = (int) t * 5;
        Bukkit.broadcastMessage(prefix + "§6Der Timer wurde gestoppt!");
        Bukkit.broadcastMessage(prefix + "§7Die Challenge wurde nach §a" + format.format(hours) + ":" + format.format(minutes) + ":" + format.format(seconds) + ":" + format.format(milliseconds) + " §2§lerfolgreich §7abgeschlossen!");
        Bukkit.getOnlinePlayers().forEach(entry ->{
                fireworks.put(entry.getLocation(), 30);
        });
    }
}
