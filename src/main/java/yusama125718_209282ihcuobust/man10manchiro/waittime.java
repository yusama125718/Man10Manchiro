package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static yusama125718_209282ihcuobust.man10manchiro.Man10Manchiro.*;

public class waittime extends Thread
{
    @Override
    public void run()
    {
        loop: for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                if (playerperson == sitperson)
                {
                    activegame = false;
                    break loop;
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!dissableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r" + Bukkit.getOfflinePlayer(fathername).getName() + "§lが一人あたり" + betvalue + "§l円で§e§lマンチロ§f§lを子" + playerperson + "人で募集中！ /mcr join で参加しましょう！残り" + (120 - i * 20) + "秒");
                }
            }
        }
        if (playerperson == sitperson)
        {
            Game gamethread = new Game();
            gamethread.start();
        }
        else
        {
            vaultapi.deposit(fathername,betvalue * playerperson);
            for (int i = 0;i == playerperson;i++)
            {
                vaultapi.deposit((childplayer.get(i)),betvalue);
            }
            operation = false;
            activegame = false;
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!dissableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§f§l" + Bukkit.getOfflinePlayer(fathername).getName() + "の部屋は人が集まらなかったので解散しました");
                }
            }
        }
    }
}
