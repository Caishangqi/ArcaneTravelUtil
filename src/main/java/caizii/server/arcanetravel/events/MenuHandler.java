package caizii.server.arcanetravel.events;

import caizii.server.arcanetravel.menu.AS_confirm_menu;
import caizii.server.arcanetravel.menu.AS_create_menu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class MenuHandler implements Listener {
    //盔甲储存HashMap
    public HashMap<Player, ArmorStand> armorstandinfo = new HashMap<>();

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

    @EventHandler
    public void onAsMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        //菜单列表
        final String AS_MAIN_MENU = ChatColor.BLACK + "ArmourStand GUi";
        final String AS_CREATE_MENU = ChatColor.DARK_GREEN + "Create a ArmorStand";
        final String AS_CONFIRM_MENU = ChatColor.DARK_GREEN + "CONFIRM OPTION";


        if (event.getView().getTitle().equalsIgnoreCase(AS_MAIN_MENU)) {
            if (event.getCurrentItem() == null) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("opened Armor Stand Create Menu");

                    //打开盔甲架编辑界面todo
                    AS_create_menu menu = new AS_create_menu();
                    menu.AS_create_menu(player);
                    break;
                case RED_STAINED_GLASS_PANE:
                    player.sendMessage("Closing the AS menu");
                    player.closeInventory();
                    break;
                default:
                    return;
            }
        } else if (event.getView().getTitle().equalsIgnoreCase(AS_CREATE_MENU)) {
            //在这里创建一个随时可以被修改的盔甲架
            //这个if是防止玩家再打开create菜单后关闭所造成的数据堆积和重复
            //如果玩家已经在这个hashmap中则不执行任何动作，这个取反就是玩家没有在key中才会执行新建
            //值进入Hashmap
            if (!armorstandinfo.containsKey(player)) {
                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                stand.setVisible(false);
                armorstandinfo.put(player, stand);
            }

            if (event.getCurrentItem() == null) {
                return;
            }

            switch (event.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("Add Arms?");
                    AS_confirm_menu arms_menu = new AS_confirm_menu();
                    arms_menu.AS_confrim_menu(player, Material.ARMOR_STAND);
                    break;
                case LANTERN:
                    player.sendMessage("Add Glow?");
                    AS_confirm_menu glow_menu = new AS_confirm_menu();
                    glow_menu.AS_confrim_menu(player, Material.LANTERN);
                    break;
                case LEATHER_CHESTPLATE:
                    player.sendMessage("Choose Armor?");
                    //建立选择盔甲界面
                    break;
                case ANDESITE_SLAB:
                    player.sendMessage("Add Base?");
                    AS_confirm_menu base_menu = new AS_confirm_menu();
                    base_menu.AS_confrim_menu(player, Material.ANDESITE_SLAB);
                    break; //千万别忘了break;否则直接执行后面的
                case GREEN_STAINED_GLASS_PANE:
                    player.sendMessage("Created Armor Stand");
                    if (armorstandinfo.containsKey(player)) {
                        ArmorStand stand = armorstandinfo.get(player);
                        stand.setVisible(true);
                        armorstandinfo.remove(player);
                        player.sendMessage(ChatColor.RED + "释放HashMap缓存");
                    }
                case RED_STAINED_GLASS_PANE:
                    player.sendMessage("Delete Armor Stand");
                    if (armorstandinfo.containsKey(player)) {
                        ArmorStand stand = armorstandinfo.get(player);
                        stand.remove();
                        armorstandinfo.remove(player);
                        player.sendMessage(ChatColor.RED + "释放HashMap缓存");
                    }

                    player.closeInventory();
                    break;
                default:
                    return;

            }
            event.setCancelled(true);

        } else if (event.getView().getTitle().equalsIgnoreCase(AS_CONFIRM_MENU)) {

            if (event.getCurrentItem() == null) {
                return;
            }

            //判断confirmmenu里面有没有armorstand，有的话每个的confirm 和 cancel执行不一样的行为
            if (event.getClickedInventory().contains(Material.ARMOR_STAND)) {
                switch (event.getCurrentItem().getType()) {
                    case GREEN_STAINED_GLASS_PANE:
                        player.sendMessage("Option Confirmed");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setArms(true);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    case RED_STAINED_GLASS_PANE:
                        player.sendMessage("Option Cancelled");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setArms(false);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    default:
                        return;
                }
            }else if (event.getClickedInventory().contains(Material.LANTERN)) {
                switch (event.getCurrentItem().getType()) {
                    case GREEN_STAINED_GLASS_PANE:
                        player.sendMessage("Option Confirmed");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setGlowing(true);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    case RED_STAINED_GLASS_PANE:
                        player.sendMessage("Option Cancelled");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setGlowing(false);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    default:
                        return;
                }
            }else if (event.getClickedInventory().contains(Material.ANDESITE_SLAB)) {
                switch (event.getCurrentItem().getType()) {
                    case GREEN_STAINED_GLASS_PANE:
                        player.sendMessage("Option Confirmed");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setBasePlate(true);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    case RED_STAINED_GLASS_PANE:
                        player.sendMessage("Option Cancelled");
                        if (armorstandinfo.containsKey(player)) {
                            ArmorStand stand = armorstandinfo.get(player);
                            stand.setBasePlate(false);
                        }
                        AS_create_menu.AS_create_menu(player);
                        break;
                    default:
                        return;
                }
            }

            event.setCancelled(true);
        }
    }
}
