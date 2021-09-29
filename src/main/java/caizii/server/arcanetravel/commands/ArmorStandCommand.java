package caizii.server.arcanetravel.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class ArmorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            //你不能直接使用ArmorStand作为Entity因为Armorstand有自己特殊的方法
            //因此你要创建  ArmorStand 类型的对象
            ArmorStand armorstand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorstand.setHelmet(new ItemStack(Material.JUNGLE_PLANKS));
            armorstand.setInvulnerable(true);
            armorstand.setGlowing(true);
            armorstand.setItemInHand(new ItemStack(Material.DIAMOND_AXE));
            armorstand.setArms(true);
            //在这个网站找到角度设定 https://haselkern.com/Minecraft-ArmorStand/
            armorstand.setHeadPose(new EulerAngle(Math.toRadians(90), 0, 0));
            armorstand.setLeftArmPose(new EulerAngle(0, 0, Math.toRadians(269)));
            armorstand.setRightArmPose(new EulerAngle(0, 0, Math.toRadians(92)));
            armorstand.setGravity(false);
        }


        return true;
    }
}
