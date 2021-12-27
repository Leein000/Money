package money.dev;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Dev extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("수표")) { // 수표 금액 갯수
            if(args.length != 2) {                              //args[0] args[1]
                sender.sendMessage("커멘드를 길게");              //1000 2 "1000" "2"
                return true;
            }
            int money = 0;
            int num = 0;
            Player p =(Player) sender;
            try {

                money = Integer.parseInt(args[0]);
                num = Integer.parseInt(args[1]);

            } catch(Exception e) {
                p.sendMessage("오류 발생");
                return true;
            }

            ItemStack paper = new ItemStack(Material.PAPER);
            ItemMeta im = paper.getItemMeta();
            im.setDisplayName(args[0]);
            paper.setItemMeta(im);

            for(int i = 0; i < num; i++) {
                p.getInventory().addItem(paper);
            }

        }
        return false;
    }

}