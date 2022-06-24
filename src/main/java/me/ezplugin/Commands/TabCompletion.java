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
            arg.add("help");
            arg.add("stats");

            if(sender.isOp()) {
                arg.add("pickaxe");
                arg.add("reset");
                arg.add("set");
                arg.add("resetall");
            }
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
