package net.projectx.challenge.functions.inventorys;

import net.projectx.api.util.menu.MenuItem;
import net.projectx.api.util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Yannick on 30.10.2019 with IntelliJ for PXCode.
 */
public class GameruleInventory extends PopupMenu {
    static int rows = 4;
    public GameruleInventory(Player p){
        super("§e§lGamerule", rows);

        addMenuItem(new MenuItem("§e§lZurück") {
            @Override
            public void onLeftClick(Player player) {
                closeMenu(p);
                new SettingsInventory(p);
            }

            @Override
            public void onRightClick(Player player) {
                closeMenu(p);
                new SettingsInventory(p);
            }
        }, 27);
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


    }

}
