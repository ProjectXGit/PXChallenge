package net.projectx.challenge.functions.commands;

import net.projectx.api.util.Command.PXCommand;
import net.projectx.challenge.functions.inventorys.SettingsInventory;
import org.bukkit.entity.Player;

/**
 * Created by Yannick on 30.10.2019 with IntelliJ for PXCode.
 */
public class cmd_settings {
    @PXCommand(
            name = "settings",
            maxArgs = 0,
            aliases = {"s"},
            permissions = "px.challenge.settings",
            noConsole = true
    )
    public void execute(Player p){
        new SettingsInventory(p);
    }
}
