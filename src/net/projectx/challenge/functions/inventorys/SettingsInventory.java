package net.projectx.challenge.functions.inventorys;


import net.projectx.api.main.PXAPI;
import net.projectx.api.util.ItemStackBuilder;
import net.projectx.api.util.menu.MenuItem;
import net.projectx.api.util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static net.projectx.api.main.Data.symbol;

/**
 * Created by Yannick on 30.10.2019 with IntelliJ for PXCode.
 */
public class SettingsInventory extends PopupMenu implements Listener{
    static int rows = 4;
    //DesignZiel der Challenge, Herausforderungp
    public SettingsInventory(Player p){
        super("§l" + symbol + "§e§lEinstellungen", rows);


        addMenuItem(new MenuItem("§e§lGamerules", new ItemStack(Material.REDSTONE_TORCH)) {

            @Override
            public void onLeftClick(Player player) {
                closeMenu(p);
                new GameruleInventory(p);
            }

            @Override
            public void onRightClick(Player player) {
                closeMenu(p);
                new GameruleInventory(p);
            }
        }, 18);


        for(int i = 0; i < rows * 9; i++){
            addMenuItem(new MenuItem("", new ItemStack(Material.GRAY_STAINED_GLASS_PANE)){
                @Override
                public void onLeftClick(Player player) {
                }

                @Override
                public void onRightClick(Player player) {

                }


            }, i);
        }
        openMenu(p);

    }


}
