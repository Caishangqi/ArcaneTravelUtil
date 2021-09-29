package caizii.server.arcanetravel.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuHandler implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        //第一步检查那个Inventory被打开，防止其他Inventory被干扰
        //getView 是背包+GUi的样子，必须使用它因为其他方法不提供 Gettitle 这个方法
        if (event.getView().getTitle().equalsIgnoreCase("Arcane Travel")) {
            //防止使用鼠标移动物品
            event.setCancelled(true);
            //这里判断是否getCurrentItem()返回空值，因为如果你点击空的GUI则没有ItemsType
            if (event.getCurrentItem() == null) {
                return;
            } else if (event.getCurrentItem().getType().equals(Material.ORANGE_STAINED_GLASS_PANE)) {
                player.sendMessage("This is help buttom");

            } else if (event.getCurrentItem().getType().equals(Material.PURPLE_STAINED_GLASS_PANE)) {
                player.sendMessage("This is setting buttom");

            }
        }
    }
}
