package me.ezplugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {

    List<String> arg = new ArrayList<>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(arg.isEmpty()) {
            arg.add("forge");
            arg.add("pickaxe");
            arg.add("stats");
            arg.add("reset");
            arg.add("set");
            arg.add("resetall");
            arg.add("miner");
            arg.add("adminworld");
            arg.add("help");
        }

        List<String> result = new ArrayList<>();
        if(args.length == 1) {
            for (String a : arg) {
                if(a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }
        return null;
    }


}
