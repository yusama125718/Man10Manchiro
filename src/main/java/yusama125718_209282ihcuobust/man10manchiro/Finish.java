package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static yusama125718_209282ihcuobust.man10manchiro.Game.*;
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
                player.sendMessage("§l[§e§lManchiro§f§l]§r" + Bukkit.getOfflinePlayer(parentname).getName() + "§lの部屋が終了しました");
            }
        }
        operation = false;
        LocalDateTime ldt = LocalDateTime.now();
        MySQLManager mysql = new MySQLManager(manchiro,"manchiro");
        mysql.execute("insert into manchiro_finish (endtime, betvalue, playercount, parent, parentuuid, parentyaku, parentwin, child1, child1uuid, child1yaku, child1win, child2, child2uuid, child2yaku, child2win, child3, child3uuid, child3yaku, child3win, child4, child4uuid, child4yaku, child4win, child5, child5uuid, child5yaku, child5win) values (" + ldt + ", "+ betvalue +", "+ playerperson +", "+ parentname +", " + Bukkit.getOfflinePlayer(parentname).getName() + ", "+ parentyaku +", "+ parentprice +", "+ Bukkit.getOfflinePlayer(childplayer.get(0)).getName() +", " + childplayer.get(0) +", "+ childyaku[0] +", "+ childprice[0] +", "+ Bukkit.getOfflinePlayer(childplayer.get(1)).getName() +", " + childplayer.get(1) +", "+ childyaku[1] +", "+ childprice[1] +", "+ Bukkit.getOfflinePlayer(childplayer.get(2)).getName() +", " + childplayer.get(2) +", "+ childyaku[2] +", "+ childprice[2] +", "+ Bukkit.getOfflinePlayer(childplayer.get(3)).getName() +", " + childplayer.get(3) +", "+ childyaku[3] +", "+ childprice[3] +", "+ Bukkit.getOfflinePlayer(childplayer.get(4)).getName() +", " + childplayer.get(4) +", "+ childyaku[4] +", "+ childprice[4] +")");
        ResultSet rs = mysql.query("select taxprice from manchiro_finish;");
        try
        {
            if(rs.next())
            {
                mysql.query("update manchiro_finish set taxprice = taxprice + "+taxprice+";");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        mysql.close();
        outnumber.clear();
        parentname = null;
        childplayer.clear();
        sitperson = 0;
    }
}
