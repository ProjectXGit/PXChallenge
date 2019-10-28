package net.projectx.challenge.functions.commands;

import net.projectx.api.main.Data;
import net.projectx.api.util.Command.PXCommand;
import org.bukkit.ChatColor;

/**
 * ~Yannick on 27.10.2019 at 17:32 o´ clock
 */
public class cmd_timer {
    StringBuilder builder;

    @PXCommand(
            name = "timer",
            aliases = {"t"},
            maxArgs = 0
    )
    public void execute() {
        builder.append(Data.prefix + "§7§lHilfsübersicht:§r\n");
        add("reset", "Resetet den Timer!");
        add("resume", "Setzt den Timer fort!");
        add("stop", "Stoppt den Timer!");
    }


    private void add(String command, String usage) {
        builder.append("\n" + Data.symbol + "§e/timer " + command + "§8: §7 " + usage + ChatColor.RESET + "\n");
    }

}
