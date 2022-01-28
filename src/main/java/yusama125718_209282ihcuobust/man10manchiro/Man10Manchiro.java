package yusama125718_209282ihcuobust.man10manchiro;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

import static java.lang.Integer.parseInt;

public final class Man10Manchiro extends JavaPlugin
{
    public static UUID fathername;
    public static double betvalue;
    static boolean operation = false;
    static boolean activegame = false;
    static boolean ongame = false;
    static public List<UUID> dissableplayers=new ArrayList<>();
    private OfflinePlayer playerid;
    static int playerperson;
    static int sitperson = 0;
    static public List<UUID> childplayer = new ArrayList<>();
    public static JavaPlugin manchiro;
    public static VaultAPI vaultapi;

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        vaultapi = new VaultAPI();
        this.manchiro = this;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player playerid = (Player) sender;
            if (sender.hasPermission("mcr.player"))
            {
                switch (args.length)
                {
                    case 1:
                    {
                        if (args[0].equals("help"))
                        {
                            if (sender.hasPermission("mcr.op"))
                            {
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr hide : §l非表示にします");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr show : §l表示します");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr join : §l現在立っている部屋に入ります");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr start [かけ金] [人数] : §l部屋を立て、親となります(かけ金を人数分支払います)");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr on : §lマンチロをonにします");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr off : §lマンチロをoffにします");
                                return true;
                            }
                            else
                            {
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr hide : §l非表示にします");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr show : §l表示します");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr join : §l現在立っている部屋に入ります");
                                sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr start [かけ金] [人数] : §l部屋を立て、親となります(かけ金を人数分支払います)");
                                return true;
                            }
                        }
                        if (args[0].equals("hide"))
                        {
                            if (dissableplayers.contains(playerid.getUniqueId()))
                            {
                                return true;
                            }
                            else
                            {
                                dissableplayers.add(playerid.getUniqueId());
                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§7§l非表示にします");
                                return true;
                            }
                        }

                        if (args[0].equals("show"))
                        {
                            if (dissableplayers.contains(playerid.getUniqueId()))
                            {
                                dissableplayers.remove(playerid.getUniqueId());
                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§7§l表示します");

                                return true;
                            }
                            else
                            {
                                return true;
                            }
                        }
                        if (sender.hasPermission("mcr.op"))
                        {
                            if (args[0].equals("on"))
                            {
                                ongame = true;
                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§lonにしました");
                                return true;
                            }
                            if (args[0].equals("off"))
                            {
                                ongame = false;
                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§loffにしました");
                                return true;
                            }
                        }
                        if (args[0].equals("join"))
                        {
                            if (activegame)
                            {
                                if (!(((Player) sender).getUniqueId() == fathername)||childplayer.contains(sender.getName()))
                                {
                                    if (vaultapi.getBalance(((Player) sender).getUniqueId()) > betvalue)
                                    {
                                        if (dissableplayers.contains(playerid.getUniqueId()))
                                        {
                                            dissableplayers.remove(playerid.getUniqueId());
                                            sender.sendMessage("§l[§e§lManchiro§f§l]§r§7§l表示します");
                                        }
                                        vaultapi.withdraw(((Player) sender).getUniqueId(),betvalue);
                                        childplayer.add(((Player) sender).getUniqueId());
                                        for (Player player: Bukkit.getOnlinePlayers())
                                        {
                                            if (childplayer.contains(player.getUniqueId()))
                                            {
                                                player.sendMessage("§l[§e§lManchiro§f§l]§r" + sender.getName() + "§lが部屋に入りました。");
                                            }
                                            if(player.getUniqueId() == fathername)
                                            {
                                                player.sendMessage("§l[§e§lManchiro§f§l]§r" + sender.getName() + "§lが部屋に入りました。");
                                            }
                                        }
                                        sitperson = sitperson + 1;
                                        return true;
                                    }
                                    else
                                    {
                                        sender.sendMessage("§l[§e§lManchiro§f§l]§r§l所持金が足りません！");
                                        return true;
                                    }
                                }
                                else
                                {
                                    sender.sendMessage("§l[§e§lManchiro§f§l]§r§lあなたはすでに参加しています！");
                                    return true;
                                }
                            }
                            else
                            {
                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§l人数がいっぱいかゲームが開かれていません");
                                return true;
                            }
                        }
                    }
                    case 3:
                    {
                        if (args[0].equals("start"))
                        {
                            if (ongame)
                            {
                                if (!operation)
                                {
                                    boolean isNumeric = args[1].matches("-?\\d+");
                                    if (isNumeric)
                                    {
                                        boolean isNumeric1 = args[1].matches("-?\\d+");
                                        if (isNumeric1)
                                        {
                                            betvalue = Double.parseDouble(args[1]);
                                            if (betvalue >= 1000)
                                            {
                                                playerperson = parseInt(args[2]);
                                                if (playerperson >= 1)
                                                {
                                                    if (playerperson <= 5)
                                                    {
                                                        if (vaultapi.getBalance(((Player) sender).getUniqueId()) > betvalue * playerperson)
                                                        {
                                                            operation = true;
                                                            activegame = true;
                                                            vaultapi.withdraw(((Player) sender).getUniqueId(),betvalue * playerperson);

                                                            waittime wait = new waittime();
                                                            wait.start();

                                                            if (dissableplayers.contains(playerid.getUniqueId()))
                                                            {
                                                                dissableplayers.remove(playerid.getUniqueId());
                                                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§7§l表示します");
                                                            }
                                                            for (Player player: Bukkit.getOnlinePlayers())
                                                            {
                                                                if (!dissableplayers.contains(player.getUniqueId()))
                                                                {
                                                                    player.sendMessage("§l[§e§lManchiro§f§l]§r" + sender.getName() + "§lが一人あたり" + betvalue + "§l円で§e§lマンチロ§f§lを子" + playerperson + "人で開始しました！ /mcr join で参加しましょう！");
                                                                }
                                                            }
                                                            fathername = ((Player) sender).getUniqueId();
                                                            return true;
                                                        }
                                                        else
                                                        {
                                                            sender.sendMessage("§l[§e§lManchiro§f§l]§r§l所持金が足りません！");
                                                            return true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        sender.sendMessage("§l[§e§lManchiro§f§l]§r§l人数は5人以下にしてください");
                                                        return true;
                                                    }
                                                }
                                                else
                                                {
                                                    sender.sendMessage("§l[§e§lManchiro§f§l]§r§l人数は1人以上にしてください");
                                                    return true;
                                                }
                                            }
                                            else
                                            {
                                                sender.sendMessage("§l[§e§lManchiro§f§l]§r§lかけ金は1000円以上にしてください");
                                                return true;
                                            }
                                        }
                                        else
                                        {
                                            sender.sendMessage("§l[§e§lManchiro§f§l]§r§l人数は数字にしてください");
                                            return true;
                                        }
                                    }
                                    else
                                    {
                                        sender.sendMessage("§l[§e§lManchiro§f§l]§r§lかけ金は数字にしてください");
                                        return true;
                                    }
                                }
                                else
                                {
                                    sender.sendMessage(("§l[§e§lManchiro§f§l]現在ゲーム中です"));
                                    return true;
                                }

                            }
                            else
                            {
                                sender.sendMessage(("§l[§e§lManchiro§f§l]現在マンチロはoffです"));
                                return true;
                            }
                        }
                        else
                        {
                            sender.sendMessage(("§l[§e§lManchiro§f§l]/mcr help でコマンドを確認できます"));
                            return true;
                        }
                    }
                    default:
                    {
                        if (sender.hasPermission("mcr.op"))
                        {
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr hide : §l非表示にします");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr show : §l表示します");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr join : §l現在立っている部屋に入ります");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr start [かけ金] [人数] : §l部屋を立て、親となります(かけ金を人数分支払います)");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr on : §lマンチロをonにします");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr off : §lマンチロをoffにします");
                            return true;
                        }
                        else
                        {
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr hide : §l非表示にします");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr show : §l表示します");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr join : §l現在立っている部屋に入ります");
                            sender.sendMessage("§l[§e§lManchiro§f§l] §7/mcr start [かけ金] [人数] : §l部屋を立て、親となります(かけ金を人数分支払います)");
                            return true;
                        }
                    }
                }
            }
            else
            {
                sender.sendMessage(("§c[manchiro]You don't have permissions!"));
                return true;
            }
        }
        else
        {
            sender.sendMessage(("§c[manchiro]Player以外は実行できません"));
            return true;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
