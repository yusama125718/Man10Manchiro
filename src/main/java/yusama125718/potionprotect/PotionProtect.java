package yusama125718.potionprotect;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.BrewingStandFuelEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static java.lang.Integer.parseInt;

public final class PotionProtect extends JavaPlugin implements Listener, CommandExecutor, TabCompleter {

    public static JavaPlugin potp;
    public static HashMap<Material,List<Integer>> allowitem = new HashMap<>();
    public static boolean operation;

    @Override
    public void onEnable() {    //起動処理
        potp = this;

        saveDefaultConfig();        //configロード
        Bukkit.broadcast("§9§l[PotionProtect] §rリロードします", "potp.op");
        List<Integer> blaze = potp.getConfig().getIntegerList("BLAZE_POWDER");
        allowitem.put(Material.BLAZE_POWDER,blaze);
        List<Integer> fspider = potp.getConfig().getIntegerList("FERMENTED_SPIDER_EYE");
        allowitem.put(Material.FERMENTED_SPIDER_EYE,fspider);
        List<Integer> ghast = potp.getConfig().getIntegerList("GHAST_TEAR");
        allowitem.put(Material.GHAST_TEAR,ghast);
        List<Integer> melon = potp.getConfig().getIntegerList("GLISTERING_MELON_SLICE");
        allowitem.put(Material.GLISTERING_MELON_SLICE,melon);
        List<Integer> carrot = potp.getConfig().getIntegerList("GOLDEN_CARROT");
        allowitem.put(Material.GOLDEN_CARROT,carrot);
        List<Integer> magma = potp.getConfig().getIntegerList("MAGMA_CREAM");
        allowitem.put(Material.MAGMA_CREAM,magma);
        List<Integer> phantom = potp.getConfig().getIntegerList("PHANTOM_MEMBRANE");
        allowitem.put(Material.PHANTOM_MEMBRANE,phantom);
        List<Integer> pufferfish = potp.getConfig().getIntegerList("PUFFERFISH");
        allowitem.put(Material.PUFFERFISH,pufferfish);
        List<Integer> rabbit = potp.getConfig().getIntegerList("RABBIT_FOOT");
        allowitem.put(Material.RABBIT_FOOT,rabbit);
        List<Integer> spider = potp.getConfig().getIntegerList("SPIDER_EYE");
        allowitem.put(Material.SPIDER_EYE,spider);
        List<Integer> sugar = potp.getConfig().getIntegerList("SUGAR");
        allowitem.put(Material.SUGAR,sugar);
        List<Integer> turtle = potp.getConfig().getIntegerList("TURTLE_HELMET");
        allowitem.put(Material.TURTLE_HELMET,turtle);
        operation = potp.getConfig().getBoolean("system");
        Bukkit.broadcast("§9§l[PotionProtect] §rリロード完了", "potp.op");

        getServer().getPluginManager().registerEvents(this, this);      //Event用
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {   //コマンド処理
        if (!sender.hasPermission("potp.op")) {         //permission確認
            sender.sendMessage("§c[PotionProtect] You don't have Permission");
            return true;
        }

        switch (args.length) {
            case 1:
                switch (args[0]) {
                    case "help":        //help
                        sender.sendMessage("§9§l[PotionProtect] §7/potp on/off §rシステムをon/offします");
                        sender.sendMessage("§9§l[PotionProtect] §7/potp add [数字] §r手に持っているアイテムの指定したカスタムモデルデータのポーションへの使用を許可します");
                        sender.sendMessage("§9§l[PotionProtect] §7/potp delete [数字] §r手に持っているアイテムの指定したカスタムモデルデータのポーションへの使用を禁止します");
                        sender.sendMessage("§9§l[PotionProtect] §7/potp check §r手に持っているアイテムの許可されているカスタムモデルデータを確認します");
                        return true;

                    case "check":       //登録確認
                        Material inhand = ((Player) sender).getInventory().getItemInMainHand().getType();
                        if (!allowitem.containsKey(inhand)) {
                            sender.sendMessage("§9§l[PotionProtect] §cそのアイテムは使えません");
                            return true;
                        }
                        sender.sendMessage("===== 許可されているカスタムモデルデータ =====");
                        for (Integer number : allowitem.get(inhand)) {
                            sender.sendMessage(String.valueOf(number));
                        }
                        return true;

                    case "on":      //システムon
                        if (operation) {
                            sender.sendMessage("§9§l[PotionProtect] §cすでに有効になっています");
                            return true;
                        }
                        operation = true;
                        potp.getConfig().set("system", operation);
                        potp.saveConfig();
                        sender.sendMessage("§9§l[PotionProtect] §r有効化しました");
                        return true;

                    case "off":     //システムoff
                        if (!operation) {
                            sender.sendMessage("§9§l[PotionProtect] §cすでに無効になっています");
                            return true;
                        }
                        operation = false;
                        potp.getConfig().set("system", operation);
                        potp.saveConfig();
                        sender.sendMessage("§9§l[PotionProtect] §r無効化しました");
                        return true;

                    default:
                        sender.sendMessage("§9§l[PotionProtect] §7/potp help §rでhelpを表示");
                        return true;
                }

            case 2:
                if (args[0].equals("add")) {     //追加処理
                    Material inhand = ((Player) sender).getInventory().getItemInMainHand().getType();
                    if (!allowitem.containsKey(inhand)) {
                        sender.sendMessage("§9§l[PotionProtect] §cそのアイテムは使えません");
                        return true;
                    }
                    boolean isNumeric = args[1].matches("-?\\d+");
                    if (!isNumeric) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    if (args[1].length() >= 10) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    int addnumber = parseInt(args[1]);
                    if (addnumber < 0) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    if (allowitem.get(inhand).contains(addnumber)) {
                        sender.sendMessage("§9§l[PotionProtect] §cその番号はすでに登録されています");
                        return true;
                    }
                    List<Integer> addlist = allowitem.get(inhand);
                    addlist.add(addnumber);
                    allowitem.replace(inhand, addlist);
                    potp.getConfig().set(inhand.toString(), allowitem.get(inhand));
                    potp.saveConfig();
                    sender.sendMessage("§9§l[PotionProtect] §r追加しました");
                }

                else if (args[0].equals("delete")) {     //削除処理
                    Material inhand = ((Player) sender).getInventory().getItemInMainHand().getType();
                    if (!allowitem.containsKey(inhand)) {
                        sender.sendMessage("§9§l[PotionProtect] §cそのアイテムは使えません");
                        return true;
                    }
                    boolean isNumeric = args[1].matches("-?\\d+");
                    if (!isNumeric) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    if (args[1].length() >= 10) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    int removenumber = parseInt(args[1]);
                    if (removenumber < 0) {
                        sender.sendMessage("§9§l[PotionProtect] §c無効な数字です");
                        return true;
                    }
                    if (!allowitem.get(inhand).contains(removenumber)) {
                        sender.sendMessage("§9§l[PotionProtect] §cその番号は存在しません");
                        return true;
                    }
                    List<Integer> removelist = allowitem.get(inhand);
                    for (int i = 0;i < removelist.size() - 1;i++) {
                        if (removelist.get(i) == removenumber) {
                            removelist.remove(i);
                            break;
                        }
                    }
                    allowitem.replace(inhand, removelist);
                    potp.getConfig().set(inhand.toString(), allowitem.get(inhand));
                    potp.saveConfig();
                    sender.sendMessage("§9§l[PotionProtect] §r削除しました");
                }

                else{
                    sender.sendMessage("§9§l[PotionProtect] §7/potp help §rでhelpを表示");
                    return true;
                }

            default:
                sender.sendMessage("§9§l[PotionProtect] §7/potp help §rでhelpを表示");
                return true;
        }
    }

    @EventHandler
    public void BrewingStandFuelEvent(BrewingStandFuelEvent event) {
        if (!operation) return;
        if (!allowitem.containsKey(event.getFuel().getType())) return;
        for (Integer number : allowitem.get(Material.BLAZE_POWDER)) {       //確認処理
            if (!event.getFuel().hasItemMeta()) return;
            if (event.getFuel().getItemMeta().getCustomModelData() == number) return;
        }
        event.setCancelled(true);       //キャンセル処理
    }

    @EventHandler
    public void BrewEvent(BrewEvent event) {
        if (!operation) return;
        if (!allowitem.containsKey(Objects.requireNonNull(event.getContents().getIngredient()).getType())) return;
        for (Integer number : allowitem.get(event.getContents().getIngredient().getType())) {       //確認処理
            if (!event.getContents().getIngredient().hasItemMeta()) return;
            if (event.getContents().getIngredient().getItemMeta().getCustomModelData() == number) return;
        }
        event.setCancelled(true);       //キャンセル処理
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!sender.hasPermission("potp.op")) return null;      //permission確認

        if(command.getName().equalsIgnoreCase("potp")){
            if (args.length == 1){
                if (args[0].length() == 0)
                {
                    return Arrays.asList("add","check","delete","help","off","on");
                }

                else {
                    if ("on".startsWith(args[0])&&"off".startsWith(args[0]))
                    {
                        return Arrays.asList("off","on");
                    }
                    else if ("add".startsWith(args[0]))
                    {
                        return Collections.singletonList("add");
                    }
                    else if ("check".startsWith(args[0]))
                    {
                        return Collections.singletonList("check");
                    }
                    else if ("delete".startsWith(args[0]))
                    {
                        return Collections.singletonList("delete");
                    }
                    else if ("help".startsWith(args[0]))
                    {
                        return Collections.singletonList("help");
                    }
                    else if ("on".startsWith(args[0]))
                    {
                        return Collections.singletonList("on");
                    }
                    else if ("off".startsWith(args[0]))
                    {
                        return Collections.singletonList("off");
                    }
                }
            }
            else if (args.length == 2){
                if (args[0].equals("add")||args[0].equals("delete")){
                    return Collections.singletonList("[カスタムモデルデータ]");
                }
            }
        }
        return null;
    }
}
