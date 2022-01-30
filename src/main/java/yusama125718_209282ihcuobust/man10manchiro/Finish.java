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
        sitperson = 0;
        LocalDateTime ldt = LocalDateTime.now();
        MySQLManager mysql = new MySQLManager(manchiro,"manchiro");
        mysql.execute("insert into mcr_data(endtime,betvalue,playercount,parent,parentuuid,parentyaku,parentwin)values(" + ldt + ","+ betvalue +","+ playerperson +","+ parentname +"," + Bukkit.getOfflinePlayer(parentname).getName() + ","+ parentyaku +","+ parentprice +");");
        for (int i = 0;i<=sitperson;i++)
        {
            mysql.execute("insert into mcrdata(child"+i+",child"+i+"uuid,child"+i+"yaku,child"+i+"win)values("+Bukkit.getOfflinePlayer(childplayer.get(i))+","+childplayer.get(i)+","+ childyaku[i] +","+ childprice[i] +");");
        }
        ResultSet rs = mysql.query("select taxprice from mcr_data;");
        try
        {
            if(rs.next())
            {
                mysql.query("update mcr_data set taxprice = taxprice + "+taxprice+";");
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
        parentname = null;
        childplayer.clear();
        sitperson = 0;
    }
}
