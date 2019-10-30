package net.projectx.challenge.main;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

/**
 * ~Yannick on 27.10.2019 at 17:31 o´ clock
 */
public class Data {
    public static long timer = 0;
    public static boolean timerrunning = false;
    public static HashMap<Location, Integer> fireworks = new HashMap<>();
    public static Plugin instance;
}
