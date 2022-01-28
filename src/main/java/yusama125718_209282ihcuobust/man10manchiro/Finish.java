package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static yusama125718_209282ihcuobust.man10manchiro.Game.outnumber;
import static yusama125718_209282ihcuobust.man10manchiro.Man10Manchiro.*;

public class Finish extends Thread
{
    @Override
    public void run()
    {
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!dissableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r" + Bukkit.getOfflinePlayer(fathername).getName() + "§lの部屋が終了しました");
            }
        }
        outnumber.clear();
        fathername = null;
        childplayer.clear();
        operation = false;
        sitperson = 0;
    }
}
