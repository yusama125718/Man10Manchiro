package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.swing.*;
import java.util.ArrayList;

import static yusama125718_209282ihcuobust.man10manchiro.Man10Manchiro.*;

public class Game extends Thread
{
    static int yaku = 0;
    public static String yakuname;
    public static SpinnerListModel getInstance()
    {
        return null;
    }
    static ArrayList<Integer> outnumber = new ArrayList<>();
    public static int k = 0;

    @Override
    public void run()
    {
        Dice dicethread = new Dice();
        dicethread.start();
        try
        {
            dicethread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int fathersyaku = yaku;
        yaku = 0;
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!dissableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親のターン");
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lダイスを振っています...");
            }
        }
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!dissableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪" + outnumber.get(0) + " , " + outnumber.get(1) + " , " + outnumber.get(2) + "！");
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l" + yakuname + "！！！");
            }
        }
        outnumber.clear();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        switch (fathersyaku)
        {
            case 111:
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!dissableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:5倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§lピンゾロ§f§lを出して" + (betvalue * playerperson + betvalue) + "円獲得しました！");
                    }
                }
                vaultapi.deposit(fathername,betvalue * playerperson + betvalue);
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 45:
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!dissableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:2倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§lシゴロ§f§lを出して" + (betvalue / 5 * 2 * playerperson + betvalue) + "円獲得しました！");
                    }
                }
                vaultapi.deposit(fathername,betvalue / 5 * 2 * playerperson + betvalue);
                for (int i = 0;i == playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),betvalue / 5 * 3);
                }
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 2:
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!dissableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:1倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§l役無し§f§lを出して子が" + (betvalue / 5 * 1 + betvalue) + "円獲得しました！");
                    }
                }
                vaultapi.deposit(fathername,betvalue / 5 * 4);
                for (int i = 0;i < playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),betvalue / 5 * 1 + betvalue);
                }
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 1:
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!dissableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:1倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§lヒフミ§f§lを出して子が" + (betvalue / 5 * 2 + betvalue) + "円獲得しました！");
                    }
                }
                vaultapi.deposit(fathername,betvalue / 5 * 3);
                for (int i = 0;i == playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),betvalue / 5 * 2 + betvalue);
                }
                Finish finish = new Finish();
                finish.start();
                return;
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!dissableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子のターン");
            }
        }
        for (k = 0;k < playerperson;k++)         //子の処理
        {
            outnumber.clear();
            Dice dicethread1 = new Dice();
            dicethread1.start();
            try
            {
                dicethread1.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            int childyaku = yaku;
            yaku = 0;
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!dissableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "のターン");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lダイスを振っています...");
                }
            }
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!dissableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪" + outnumber.get(0) + " , " + outnumber.get(1) + " , " + outnumber.get(2) + "！");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l" + yakuname + "！！！");
                }
            }
            outnumber.clear();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            switch (childyaku)
            {
                case 111:
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:5倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§lピンゾロ§f§lを出して" + (betvalue * 2) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue * 2);
                    Finish finish = new Finish();
                    finish.start();
                    return;
                }
                case 45:
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:2倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§lシゴロ§f§lを出して" + (betvalue + betvalue / 5 * 2) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue + betvalue / 5 * 2);
                    vaultapi.deposit(fathername,betvalue / 5 * 3);
                    Finish finish = new Finish();
                    finish.start();
                    return;
                }
                case 2:
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:1倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§l役無し§f§lを出して親が" + (betvalue / 5 * 1 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 * 4);
                    vaultapi.deposit(fathername,betvalue / 5 * 1 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                    return;
                }
                case 1:
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:1倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§lヒフミ§f§lを出して親が" + (betvalue / 5 * 2 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 * 3);
                    vaultapi.deposit(fathername,betvalue / 5 * 2 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                    return;
                }
                default:
                {
                    break;
                }
            }
            if (fathersyaku == childyaku)
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!dissableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l引き分け！");
                    }
                }
                vaultapi.deposit((childplayer.get(k)),betvalue);
                vaultapi.deposit(fathername,betvalue);
                Finish finish = new Finish();
                finish.start();
                return;
            }
            if (fathersyaku < childyaku)
            {
                if (childyaku > 20)
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:3倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§l" + yakuname + "§f§lを出して子が" + (betvalue / 5 * 3 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit(fathername,betvalue / 5 * 2);
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 * 3 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                }
                else
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§l(倍率:1倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(fathername).getName() + "が§e§l" + yakuname + "§f§lを出して子が" + (betvalue / 5 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit(fathername,betvalue / 5 * 4);
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                }
            }
            else
            {
                if (fathersyaku > 20)
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:3倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§l" + yakuname + "§f§lを出して親が" + (betvalue / 5 * 3 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 * 2);
                    vaultapi.deposit(fathername,betvalue / 5 * 3 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                }
                else
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!dissableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§l(倍率:1倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "が§e§l" + yakuname + "§f§lを出して親が" + (betvalue / 5 + betvalue) + "円獲得しました！");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),betvalue / 5 * 4);
                    vaultapi.deposit(fathername,betvalue / 5 + betvalue);
                    Finish finish = new Finish();
                    finish.start();
                }
            }
        }
    }
}
