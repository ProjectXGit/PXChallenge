package net.projectx.challenge.functions;

import net.projectx.api.util.ActionbarManager;
import net.projectx.api.util.Fireworkgenerator;
import net.projectx.challenge.main.Data;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;


import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by Yannick on 29.10.2019 with IntelliJ for PXCode.
 */
public class Scheduler {
    private static int scheduler;
    private static long counter;
    public static void startScheduler(){
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Data.instance, new Runnable() {
            @Override
            public void run() {
                timer();
                if(counter % 18 == 0) {
                    firework();
                }
                if(counter == 9999){
                    counter = 0;
                }else{
                    counter++;
                }
            }
        },0, 1);
    }

    public static void stopScheduler(){
        Bukkit.getScheduler().cancelTask(scheduler);
    }

    private static void timer(){
        if(Data.timerrunning){
            Data.timer++;
            DecimalFormat format = new DecimalFormat("00");
            long t = Data.timer;
            int hours = (int) t/(60*60*20);
            t = t % (60*60*20);
            int minutes = (int) t/(60*20);
            t = t % (60*20);
            int seconds = (int) t/(20);
            t = t % (20);
            int milliseconds = (int) t * 5;
            Bukkit.getOnlinePlayers().forEach(entry ->{
                ActionbarManager.sendActionBar(entry, "§7§lChallenge: §2§l" + format.format(hours) + ":" + format.format(minutes) + ":" + format.format(seconds) + ":" + format.format(milliseconds));
            });
        }else{
            Bukkit.getOnlinePlayers().forEach(entry ->{
                if(Data.timer == 0) {
                    ActionbarManager.sendActionBar(entry, "§6§lTimer läuft nicht!");
                }else{
                    DecimalFormat format = new DecimalFormat("00");
                    long t = Data.timer;
                    int hours = (int) t/(60*60*20);
                    t = t % (60*60*20);
                    int minutes = (int) t/(60*20);
                    t = t % (60*20);
                    int seconds = (int) t/(20);
                    t = t % (20);
                    int milliseconds = (int) t * 5;
                    ActionbarManager.sendActionBar(entry, "§6§lPausiert: " + format.format(hours) + ":" + format.format(minutes) + ":" + format.format(seconds) + ":" + format.format(milliseconds));
                }
            });
        }
    }

    public static void firework(){
        Random random = new Random();

        Iterator iterator = Data.fireworks.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            Location loc = (Location) me2.getKey();
            int fireworks = (int) me2.getValue();
            Location spawn = new Location(Bukkit.getWorld("world"), 0, 0, 0);
            spawn.setX(loc.getX()+(random.nextInt(11) - 5));
            spawn.setZ(loc.getZ()+(random.nextInt(11) - 5));
            spawn.setY(loc.getWorld().getHighestBlockAt(spawn.getBlockX(), spawn.getBlockZ()).getY() + 2);


            Fireworkgenerator fireworkgenerator = new Fireworkgenerator(Data.instance);
            fireworkgenerator.setLocation(spawn);
            fireworkgenerator.setLifeTime(20);
            fireworkgenerator.setPower(2);
            FireworkEffect.Type type;
            switch (random.nextInt(5)){
                case 0:
                    type = FireworkEffect.Type.BALL;
                    break;
                case 1:
                    type = FireworkEffect.Type.BALL_LARGE;
                    break;
                case 2:
                    type = FireworkEffect.Type.BURST;
                    break;
                case 3:
                    type = FireworkEffect.Type.CREEPER;
                    break;
                default:
                    type = FireworkEffect.Type.STAR;
                    break;
            }
            fireworkgenerator.setEffect(FireworkEffect.builder().withColor(Color.fromBGR(random.nextInt(256), random.nextInt(256), random.nextInt(256))).with(type).withFlicker().withTrail().withColor(Color.fromBGR(random.nextInt(256), random.nextInt(256), random.nextInt(256))).withColor(Color.fromBGR(random.nextInt(256), random.nextInt(256), random.nextInt(256))).build());
            fireworkgenerator.spawn();
            if(fireworks-1 == 0){
                Data.fireworks.remove(loc);
            }else{
                Data.fireworks.put(loc, fireworks-1);
            }
        }
    }
}
