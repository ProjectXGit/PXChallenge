package net.projectx.challenge.functions.inventorys;



import net.projectx.api.util.menu.MenuItem;
import net.projectx.api.util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static net.projectx.api.main.Data.symbol;
import static net.projectx.challenge.main.Data.rows;

/**
 * Created by Yannick on 30.10.2019 with IntelliJ for PXCode.
 */
public class SettingsInventory extends PopupMenu implements Listener{
    //DesignZiel der Challenge, Herausforderungp
    public SettingsInventory(Player p){
        super("§l" + symbol + "§e§lEinstellungen", rows);


        addMenuItem(new MenuItem("§e§lGamerules", new ItemStack(Material.REDSTONE_TORCH)) {

            @Override
            public void onClick(InventoryClickEvent event) {
                new GameruleInventory(p);
            }

        }, 17);

        addMenuItem(new MenuItem("§e§1Anzeige", new ItemStack(Material.NAME_TAG)) {
            @Override
            public void onClick(InventoryClickEvent event) {
                new DisplayInventory(p);
            }
        }, 10);


        for(int i = 0; i < rows * 9; i++){
            addMenuItem(new MenuItem(" ", new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE)) {
                @Override
                public void onClick(InventoryClickEvent event) {
                }



            }, i);
        }
        openMenu(p);

    }


}
