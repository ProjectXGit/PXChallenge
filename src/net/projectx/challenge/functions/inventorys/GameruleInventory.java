package net.projectx.challenge.functions.inventorys;

import net.projectx.api.util.menu.MenuItem;
import net.projectx.api.util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static net.projectx.api.main.Data.symbol;
import static net.projectx.challenge.main.Data.rows;

/**
 * Created by Yannick on 30.10.2019 with IntelliJ for PXCode.
 */
public class GameruleInventory extends PopupMenu {
    public GameruleInventory(Player p){
        super("§l" + symbol + "§e§lGamerule", rows);

        addMenuItem(new MenuItem("§e§lZurück") {
            @Override
            public void onClick(InventoryClickEvent event) {
                new SettingsInventory(p);
            }

        }, 27);
        for(int i = 0; i < rows * 9; i++){
            addMenuItem(new MenuItem(" ", new ItemStack(Material.GRAY_STAINED_GLASS_PANE)) {
                @Override
                public void onClick(InventoryClickEvent event) {
                }
            }, i);
        }

        openMenu(p);
    }

}
