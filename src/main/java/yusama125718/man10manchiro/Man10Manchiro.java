package yusama125718.man10manchiro;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Man10Manchiro extends JavaPlugin implements CommandExecutor, TabCompleter {
    public static UUID parentname;
    public static double betvalue;
    static boolean operation = false;
    static boolean activegame = false;
    static boolean ongame = false;
    static public List<UUID> disableplayers = new ArrayList<>();
    private OfflinePlayer playerid;
    static int playerperson;
    static int sitperson = 0;
    static public List<UUID> childplayer = new ArrayList<>();
    public static JavaPlugin manchiro;
    public static VaultAPI vaultapi;
    public static String starttime;

    @Override
    public void onEnable() {
        getCommand("mcr").setExecutor(new Command());
        this.manchiro = this;
        saveDefaultConfig();
        MySQLManager mysql = new MySQLManager(manchiro, "manchiro");
        mysql.execute("create table if not exists mcr_data(id int auto_increment,starttime varchar(19),endtime varchar(19),betvalue varchar(15),playercount varchar(1),tax varchar(15),parent varchar(50),parentuuid varchar(50),parentyaku varchar(3),parentwin varchar(15),child0 varchar(50),child0uuid varchar(50),child0yaku varchar(3),child0win varchar(15),child1 varchar(50),child1uuid varchar(50),child1yaku varchar(3),child1win varchar(15),child2 varchar(50),child2uuid varchar(50),child2yaku varchar(3),child2win varchar(15),child3 varchar(50),child3uuid varchar(50),child3yaku varchar(3),child3win varchar(15),child4 varchar(50),child4uuid varchar(50),child4yaku varchar(3),child4win varchar(15),primary key(id));");
        vaultapi = new VaultAPI();
        ongame = manchiro.getConfig().getBoolean("canPlay");
    }
}
