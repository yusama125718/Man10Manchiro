package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static yusama125718_209282ihcuobust.man10manchiro.Game.*;
import static yusama125718_209282ihcuobust.man10manchiro.Man10Manchiro.*;

public class Shonben extends Thread
{
    public void start()
    {
        if (parentshonben)
        {
            parentyaku = 2;
            parentprice = (betvalue / 5 * 4);
            parentwin = parentprice;
            for (int l=0;l<playerperson;l++)
            {
                childprice[l] = (betvalue / 5 + betvalue - tax * betvalue);
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親のターン");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l"+Bukkit.getOfflinePlayer(parentname).getName()+"§rが§e§lダイスを振っています...§e§kaaa");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§7お...おい...茶碗から出たぞ...");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§7これって...");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:1倍)");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§lションベン§fをして§l子が" + String.format("%,.0f", betvalue / 5 + betvalue) + "円獲得しました！§7(手数料"+String.format("%,.0f", tax * betvalue)+"円)");
                }
            }
            vaultapi.deposit(parentname,parentprice);
            for (int i = 0;i < playerperson;i++)
            {
                vaultapi.deposit((childplayer.get(i)),childprice[i]);
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(i)).getName() + "§r§l: §e§l"+String.format("%,.0f", betvalue)+"円 → "+String.format("%,.0f", childprice[i] + tax * betvalue)+"円§r§e(うち手数料"+String.format("%,.0f", tax * betvalue)+"円)");
                    }
                }
            }
        }
        else
        {
            childyaku[k] = 2;
            parentprice = (betvalue / 5 * 4 - tax * betvalue);
            parentwin = (betvalue / 5 * 4 );
            childprice[k] = (betvalue / 5 + betvalue);
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子のターン");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l"+Bukkit.getOfflinePlayer(childplayer.get(k)).getName()+"§rが§e§lダイスを振っています...§e§kaaa");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§7お...おい...茶碗から出たぞ...");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§7これって...");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:1倍)");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§c§lションベン§fをして§l子が" + String.format("%,.0f", betvalue / 5 + betvalue) + "円獲得しました！§7(手数料"+String.format("%,.0f", tax * betvalue)+"円)");
                }
            }
            vaultapi.deposit(parentname,parentprice);
            vaultapi.deposit((childplayer.get(k)),childprice[k]);
        }
        taxprice = tax * betvalue;
    }
}
