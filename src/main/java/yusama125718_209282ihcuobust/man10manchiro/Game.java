package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

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
    static ArrayList<Integer> throw1 = new ArrayList<>();
    static ArrayList<Integer> throw2 = new ArrayList<>();
    public static int k = 0;
    public static int[] childyaku = new int[5];
    static int parentyaku;
    static double parentprice = 0;
    static double[] childprice = new double[5];
    double jackpot;
    static double tax = manchiro.getConfig().getDouble("tax");
    static double taxprice = 0;
    static double parentwin;

    @Override
    public void run()
    {
        Random dicerondom = new Random();
        int s = dicerondom.nextInt(1000);
        if (s == 0)
        {
            Shonben shonbenthread = new Shonben();
            shonbenthread.start();
            return;
        }
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

        parentyaku = yaku;
        yaku = 0;
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!disableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親のターン");
                player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l"+Bukkit.getOfflinePlayer(parentname).getName()+"§rが§lダイスを振っています...§e§kaaa");
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
        if (throw1.size()>0)
        {
            Random dicerondom2 = new Random();
            int s2 = dicerondom2.nextInt(1000);
            if (s2 == 0)
            {
                Shonben shonbenthread = new Shonben();
                shonbenthread.start();
                return;
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + throw1.get(0) + " , " + throw1.get(1) + " , " + throw1.get(2) + "！");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l役無し§f§l！！！");
                }
            }
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l"+Bukkit.getOfflinePlayer(parentname).getName()+"§rが§lダイスを振り直しています...§e§kaaa");
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
            if (throw2.size()>0)
            {
                Random dicerondom3 = new Random();
                int s3 = dicerondom3.nextInt(1000);
                if (s3 == 0)
                {
                    Shonben shonbenthread = new Shonben();
                    shonbenthread.start();
                    return;
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + throw2.get(0) + " , " + throw2.get(1) + " , " + throw2.get(2) + "！");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l役無し§f§l！！！");
                    }
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l"+Bukkit.getOfflinePlayer(parentname).getName()+"§rが§lダイスを振り直しています...§e§kaaa");
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
            }
            throw1.clear();
            throw2.clear();
        }
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!disableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + outnumber.get(0) + " , " + outnumber.get(1) + " , " + outnumber.get(2) + "！");
                player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l" + yakuname + "§f§l！！！");
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
        switch (parentyaku)
        {
            case 111:
            {
                jackpot = manchiro.getConfig().getDouble("jackpot");
                if (betvalue * 10 >= jackpot)
                {
                    parentprice = jackpot - tax * betvalue;
                    parentwin = jackpot;
                }
                else
                {
                    parentprice = betvalue * 10 - tax * betvalue;
                    parentwin = betvalue * 10;
                }
                for (int l=0;l<sitperson;l++)
                {
                    childprice[l] = 0;
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(l)).getName() + "§r§l: §e§l"+betvalue+"円 → 0円§r§e(うち手数料0円)");
                        }
                    }
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f§kaa§e§r§e§lジャックポット§f§kaa");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l"+yakuname+"§fを出して§l" + (parentprice+tax*betvalue) + "円獲得しました！§7(手数料"+(tax * betvalue)+"円)");
                    }
                }
                for (int l=0;l<sitperson;l++)
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(l)).getName() + "§r§l: §e§l"+betvalue+"円 → 0円§r§e(うち手数料0円)");
                        }
                    }
                }
                vaultapi.deposit(parentname,parentprice);
                jackpot = jackpot - parentwin;
                taxprice = tax * betvalue;
                manchiro.getConfig().set("jackpot",jackpot);
                manchiro.saveConfig();
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 106:
            {
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§c§kaa§r§c全員没収§c§kaa");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l"+yakuname+"§f§lを出して没収されました！");
                    }
                }
                parentprice = 0;
                parentwin = parentprice;
                for (int l=0;l<playerperson;l++)
                {
                    childprice[l] = 0;
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(l)).getName() + "§r§l: §e§l"+betvalue+"円 → 0円§r§e(うち手数料0円)");
                        }
                    }
                }
                jackpot = manchiro.getConfig().getDouble("jackpot");
                jackpot = jackpot + betvalue * sitperson * 2;
                manchiro.getConfig().set("jackpot",jackpot);
                manchiro.saveConfig();
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 100:
            case 45:
            {
                parentprice = ((betvalue / 5 * 2 + betvalue) * sitperson - tax * betvalue);
                parentwin = ((betvalue / 5 * 2 + betvalue) * sitperson);
                for (int l=0;l<5;l++)
                {
                    childprice[l] = (betvalue / 5 * 3);
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:2倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "が§c§l"+yakuname+"§fを出して§l" + ((betvalue / 5 * 2 + betvalue) * sitperson) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                    }
                }
                vaultapi.deposit(parentname,parentprice);
                for (int i = 0;i < playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),betvalue / 5 * 3);
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(i)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 3)+"円§r§e(うち手数料0円)");
                        }
                    }
                }
                taxprice = tax * betvalue;
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 3:
            {
                parentprice = (betvalue / 5 * 4 * sitperson);
                parentwin = parentprice;
                for (int l=0;l<5;l++)
                {
                    childprice[l] = (betvalue / 5 * 1 + betvalue - tax * betvalue);
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:1倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l"+yakuname+"§fを出して§l子が" + (betvalue / 5 * 1 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                    }
                }
                vaultapi.deposit(parentname,parentprice);
                for (int i = 0;i < playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),(childprice[i]));
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(i)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 1 + betvalue)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                        }
                    }
                }
                taxprice = tax * betvalue * sitperson;
                Finish finish = new Finish();
                finish.start();
                return;
            }
            case 5:
            case 1:
            {
                parentprice = (betvalue / 5 * 3 * sitperson);
                parentwin = parentprice;
                for (int l=0;l<5;l++)
                {
                    childprice[l] = (betvalue / 5 * 2 + betvalue - tax * betvalue);
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:2倍)");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§a§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l"+yakuname+"§fを出して§l子が" + (betvalue / 5 * 2 + betvalue) + "円獲得しました！§7(手数料"+(tax * betvalue)+"円)");
                    }
                }
                taxprice = tax * betvalue * sitperson;
                vaultapi.deposit(parentname,parentprice);
                for (int i = 0;i < playerperson;i++)
                {
                    vaultapi.deposit((childplayer.get(i)),(childprice[i]));
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(i)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 2 + betvalue)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                        }
                    }
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
        String parentyakuname = yakuname;
        for (Player player: Bukkit.getOnlinePlayers())
        {
            if (!disableplayers.contains(player.getUniqueId()))
            {
                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子のターン");
            }
        }
        for (k = 0;k < playerperson;k++)         //子の処理
        {
            Random dicerondom1 = new Random();
            int s1 = dicerondom1.nextInt(1000);
            if (s1 == 0)
            {
                Shonben shonbenthread = new Shonben();
                shonbenthread.start();
                return;
            }
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
            childyaku[k] = yaku;
            yaku = 0;
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rの§lターン");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§lダイスを振っています...§e§kaaa");
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
            if (throw1.size()>0)
            {
                Random dicerondom5 = new Random();
                int s5 = dicerondom5.nextInt(1000);
                if (s5 == 0)
                {
                    Shonben shonbenthread = new Shonben();
                    shonbenthread.start();
                    return;
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + throw1.get(0) + " , " + throw1.get(1) + " , " + throw1.get(2) + "！");
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l役無し§f§l！！！");
                    }
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                for (Player player: Bukkit.getOnlinePlayers())
                {
                    if (!disableplayers.contains(player.getUniqueId()))
                    {
                        player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§lダイスを振り直しています...§e§kaaa");
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
                if (throw2.size()>0)
                {
                    Random dicerondom4 = new Random();
                    int s4 = dicerondom4.nextInt(1000);
                    if (s4 == 0)
                    {
                        Shonben shonbenthread = new Shonben();
                        shonbenthread.start();
                        return;
                    }
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + throw2.get(0) + " , " + throw2.get(1) + " , " + throw2.get(2) + "！");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l役無し§f§l！！！");
                        }
                    }
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§lダイスを振り直しています...§e§kaaa");
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
                }
                throw1.clear();
                throw2.clear();
            }
            for (Player player: Bukkit.getOnlinePlayers())
            {
                if (!disableplayers.contains(player.getUniqueId()))
                {
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§lチンチロリン♪§f§l" + outnumber.get(0) + " , " + outnumber.get(1) + " , " + outnumber.get(2) + "！");
                    player.sendMessage("§l[§e§lManchiro§f§l]§r§c§l" + yakuname + "§f§l！！！");
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
            yyy: switch (childyaku[k])
            {
                case 111:
                {
                    jackpot = manchiro.getConfig().getDouble("jackpot");
                    if (betvalue * 10 >= jackpot)
                    {
                        childprice[k] = jackpot - tax * betvalue;
                    }
                    else
                    {
                        childprice[k] = betvalue * 10 - tax * betvalue;
                    }
                    childprice[k] = betvalue * 2;
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f§kaaa§r§e§lジャックポット§f§kaaa");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§c§l"+yakuname+"§fを出して§l" + (childprice[k]+tax*betvalue) + "円獲得しました！§7(手数料"+(tax * betvalue)+"円)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(childprice[k] + tax * betvalue)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),(childprice[k]));
                    jackpot = jackpot - childprice[k] - tax * betvalue;
                    taxprice = taxprice + tax * betvalue;
                    manchiro.getConfig().set("jackpot",jackpot);
                    manchiro.saveConfig();
                    break yyy;
                }
                case 106:
                {
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§c§kaaa§r§c§l全員没収§c§kaaa");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l"+yakuname+"§fを出して§c§l没収されました！");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → 0円§r§e(うち手数料0円)");
                        }
                    }
                    childprice[k] = 0;
                    jackpot = manchiro.getConfig().getDouble("jackpot");
                    jackpot = jackpot + betvalue * 2;
                    manchiro.getConfig().set("jackpot",jackpot);
                    manchiro.saveConfig();
                    break yyy;
                }
                case 100:
                case 45:
                {
                    parentprice = (parentprice + betvalue / 5 * 3);
                    parentwin = (parentwin +  betvalue / 5 * 3);
                    childprice[k] = (betvalue + betvalue / 5 * 2 - tax * betvalue);
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:2倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§c§l"+yakuname+"§fを出して§l"+(betvalue + betvalue / 5 * 2)+"円獲得しました！§7(手数料"+(tax * betvalue)+"円)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue + betvalue / 5 * 2)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),childprice[k]);
                    vaultapi.deposit(parentname,betvalue / 5 * 3);
                    taxprice = taxprice + tax * betvalue;
                    break yyy;
                }
                case 3:
                {
                    parentprice = (betvalue / 5 + betvalue + parentprice - tax * betvalue);
                    parentwin = (betvalue / 5 + betvalue + parentwin);
                    childprice[k] = (betvalue / 5 * 4);
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:1倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§c§l"+yakuname+"§fを出して§l親が" + (betvalue / 5  + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 4)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),childprice[k]);
                    vaultapi.deposit(parentname,betvalue / 5 * 1 + betvalue - tax * betvalue);
                    taxprice = taxprice + tax * betvalue;
                    break yyy;
                }
                case 5:
                case 1:
                {
                    parentprice = (betvalue / 5 * 2 + betvalue + parentprice - tax * betvalue);
                    parentwin = (betvalue / 5 * 2 + betvalue + parentwin);
                    childprice[k] = (betvalue / 5 * 3);
                    for (Player player: Bukkit.getOnlinePlayers())
                    {
                        if (!disableplayers.contains(player.getUniqueId()))
                        {
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:2倍)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§rが§c§l"+yakuname+"§fを出して§l親が" + (betvalue / 5 * 2 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                            player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 3)+"円§r§e(うち手数料0円)");
                        }
                    }
                    vaultapi.deposit((childplayer.get(k)),childprice[k]);
                    vaultapi.deposit(parentname,betvalue / 5 * 2 + betvalue - tax * betvalue);
                    taxprice = taxprice + tax * betvalue;
                    break yyy;
                }
                default:
                {
                    if (parentyaku == childyaku[k])
                    {
                        parentprice = (parentprice + betvalue);
                        parentwin = (parentwin + betvalue);
                        childprice[k] = betvalue;
                        for (Player player: Bukkit.getOnlinePlayers())
                        {
                            if (!disableplayers.contains(player.getUniqueId()))
                            {
                                player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l引き分け！");
                                player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+betvalue+"円§r§e(うち手数料0円)");
                            }
                        }
                        vaultapi.deposit((childplayer.get(k)),betvalue);
                        vaultapi.deposit(parentname,childprice[k]);
                        break yyy;
                    }
                    if (parentyaku < childyaku[k])
                    {
                        if (childyaku[k] > 20)
                        {
                            parentprice = (betvalue / 5 * 2 + parentprice);
                            parentwin = (betvalue / 5 * 2 + parentwin);
                            childprice[k] = (betvalue / 5 * 3 + betvalue - tax * betvalue);
                            for (Player player: Bukkit.getOnlinePlayers())
                            {
                                if (!disableplayers.contains(player.getUniqueId()))
                                {
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:3倍)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l" + yakuname + "§fを出して§l子が" + (betvalue / 5 * 3 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue + betvalue / 5 * 3)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                                }
                            }
                            vaultapi.deposit(parentname,betvalue / 5 * 2);
                            vaultapi.deposit((childplayer.get(k)),childprice[k]);
                            taxprice = taxprice + tax * betvalue;
                            break yyy;
                        }
                        else
                        {
                            parentprice = (betvalue / 5 * 4 + parentprice);
                            parentwin = (betvalue / 5 * 4 + parentwin);
                            childprice[k] = (betvalue / 5 + betvalue - tax * betvalue);
                            for (Player player: Bukkit.getOnlinePlayers())
                            {
                                if (!disableplayers.contains(player.getUniqueId()))
                                {
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l子の勝ち！§f(倍率:1倍)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l" + yakuname + "§fを出して§l子が" + (betvalue / 5 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue + betvalue / 5)+"円§r§e(うち手数料"+(tax * betvalue)+"円)");
                                }
                            }
                            vaultapi.deposit(parentname,betvalue / 5 * 4);
                            vaultapi.deposit((childplayer.get(k)),childprice[k]);
                            taxprice = taxprice + tax * betvalue;
                            break yyy;
                        }
                    }
                    else
                    {
                        if (parentyaku > 20)
                        {
                            parentprice = (betvalue / 5 * 3 + betvalue + parentprice - tax * betvalue);
                            parentwin = (betvalue / 5 * 3 + betvalue + parentwin);
                            childprice[k] = (betvalue / 5 * 2);
                            for (Player player: Bukkit.getOnlinePlayers())
                            {
                                if (!disableplayers.contains(player.getUniqueId()))
                                {
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:3倍)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l" + parentyakuname + "§fを出して§l親が" + (betvalue / 5 * 3 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 2)+"円§r§e(うち手数料0円)");
                                }
                            }
                            vaultapi.deposit((childplayer.get(k)),childprice[k]);
                            vaultapi.deposit(parentname,betvalue / 5 * 3 + betvalue - tax * betvalue);
                            taxprice = taxprice + tax * betvalue;
                            break yyy;
                        }
                        else
                        {
                            parentprice = (betvalue / 5 + betvalue + parentprice - tax * betvalue);
                            parentwin = (betvalue / 5 + betvalue + parentwin);
                            childprice[k] = (betvalue / 5 * 4);
                            for (Player player: Bukkit.getOnlinePlayers())
                            {
                                if (!disableplayers.contains(player.getUniqueId()))
                                {
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§e§l親の勝ち！§f(倍率:1倍)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(parentname).getName() + "§rが§c§l" + parentyakuname + "§fを出して§l親が" + (betvalue / 5 + betvalue) + "円獲得しました！§7(手数料"+tax * betvalue+"円)");
                                    player.sendMessage("§l[§e§lManchiro§f§l]§r§b§l" + Bukkit.getOfflinePlayer(childplayer.get(k)).getName() + "§r§l: §e§l"+betvalue+"円 → "+(betvalue / 5 * 4)+"円§r§e(うち手数料0円)");
                                }
                            }
                            vaultapi.deposit((childplayer.get(k)),childprice[k]);
                            vaultapi.deposit(parentname,betvalue / 5 + betvalue - tax * betvalue);
                            taxprice = taxprice + tax * betvalue;
                            break yyy;
                        }
                    }
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
        }
        Finish finish = new Finish();
        finish.start();
        return;
    }
}
