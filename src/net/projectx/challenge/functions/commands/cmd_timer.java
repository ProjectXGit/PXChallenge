package net.projectx.challenge.functions.commands;

import net.projectx.api.util.Command.PXCommand;
import net.projectx.challenge.main.Data;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


import static net.projectx.api.main.Data.prefix;
import static net.projectx.api.main.Data.symbol;

/**
 * ~Yannick on 27.10.2019 at 17:32 o´ clock
 */
public class cmd_timer {
    StringBuilder builder;

    @PXCommand(
            name = "timer",
            aliases = {"t"},
            maxArgs = 0,
            permissions = "px.challenge.timer"
    )
    public void execute(CommandSender sender) {
        builder.append(prefix + "§7§lHilfsübersicht:§r\n");
        add("reset", "Resetet den Timer!");
        add("resume", "Setzt den Timer fort!");
        add("stop", "Stoppt den Timer!");
        sender.sendMessage(builder.toString());
    }

    @PXCommand(
            name = "reset",
            maxArgs = 0,
            minArgs = 0,
            parent = "timer"
    )
    public void execute1(CommandSender sender){
        if(!Data.timerrunning){
            Data.timer = 0;
            sender.sendMessage(prefix + "§aTimer wurde resetet!");

        }else{
            sender.sendMessage(prefix + "§cDer Timer muss gestoppt sein!");
        }
    }

    @PXCommand(
            name = "resume",
            maxArgs = 0,
            minArgs = 0,
            parent = "timer"
    )
    public void execute2(CommandSender sender){
        if(Data.timerrunning){
            sender.sendMessage(prefix + "§cTimer läuft bereits!");
        }else{
            Data.timerrunning = true;
            sender.sendMessage(prefix + "§aDer Timer wurde fortgesetzt!");
        }
    }

    @PXCommand(
            name = "stop",
            maxArgs = 0,
            minArgs = 0,
            parent = "timer"
    )
    public void execute3(CommandSender sender){
        if(!Data.timerrunning){
            sender.sendMessage(prefix + "§cTimer bereits gestoppt!");
        }else{
            Data.timerrunning = false;
            sender.sendMessage(prefix + "§aDer Timer wurde gestoppt!");

        }
    }


    private void add(String command, String usage) {
        builder.append("\n" + symbol + "§e/timer " + command + "§8: §7 " + usage + ChatColor.RESET + "\n");
    }

}
