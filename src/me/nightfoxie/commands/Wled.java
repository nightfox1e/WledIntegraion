package me.nightfoxie.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wled implements CommandExecutor, TabCompleter {
    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private static final String WLED_BASE_URL = "http://wled-main.local";
    private static void sendWledCommand(String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> System.out.println("WLED Response: " + response.body()))
                .exceptionally(e -> {
                    System.err.println("Failed to send request: " + e.getMessage());
                    return null;
                });
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    sendWledCommand(WLED_BASE_URL + "/win&T=1&CL=hFFFFFFFF&FX=0&SX=128&IX=255");
                    sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Turned WLED instance " + ChatColor.GREEN + ChatColor.BOLD + "ON" + ChatColor.RESET + ChatColor.BOLD + ".");
                }
                if (args[0].equalsIgnoreCase("off")) {
                    sendWledCommand(WLED_BASE_URL + "/win&T=0");
                    sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Turned WLED instance " + ChatColor.RED  + ChatColor.BOLD + "OFF" + ChatColor.RESET + ChatColor.BOLD + ".");
                }
                if (args[0].equalsIgnoreCase("brightness")) {
                    if (args.length == 2) {
                        sendWledCommand(WLED_BASE_URL + "/win&T=1&A=" + args[1]);
                        sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Set the brightness of WLED instance to " + ChatColor.AQUA + ChatColor.BOLD + args[1] + ChatColor.RESET + ChatColor.BOLD + ".");
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "  brightness - set the brightness of WLED instance between 0 and 255.\n");
                    }
                }
                if (args[0].equalsIgnoreCase("color")) {
                    if (args[1].equalsIgnoreCase("preset")) {
                        if (args.length == 3) {
                            int[] colorPreset = {};
                            if (args[2].equalsIgnoreCase("red")) {
                                colorPreset = new int[] {255, 0, 0};
                            }
                            if (args[2].equalsIgnoreCase("light_red")) {
                                colorPreset = new int[] {255, 102, 102};
                            }
                            if (args[2].equalsIgnoreCase("dark_red")) {
                                colorPreset = new int[] {139, 0, 0};
                            }
                            if (args[2].equalsIgnoreCase("orange")) {
                                colorPreset = new int[] {255, 165, 0};
                            }
                            if (args[2].equalsIgnoreCase("light_orange")) {
                                colorPreset = new int[] {255, 200, 102};
                            }
                            if (args[2].equalsIgnoreCase("dark_orange")) {
                                colorPreset = new int[] {255, 140, 0};
                            }
                            if (args[2].equalsIgnoreCase("yellow")) {
                                colorPreset = new int[] {255, 255, 0};
                            }
                            if (args[2].equalsIgnoreCase("light_yellow")) {
                                colorPreset = new int[] {255, 255, 153};
                            }
                            if (args[2].equalsIgnoreCase("dark_yellow")) {
                                colorPreset = new int[] {204, 204, 0};
                            }
                            if (args[2].equalsIgnoreCase("green")) {
                                colorPreset = new int[] {0, 255, 0};
                            }
                            if (args[2].equalsIgnoreCase("light_green")) {
                                colorPreset = new int[] {144, 238, 144};
                            }
                            if (args[2].equalsIgnoreCase("dark_green")) {
                                colorPreset = new int[] {0, 100, 0};
                            }
                            if (args[2].equalsIgnoreCase("blue")) {
                                colorPreset = new int[] {0, 0, 255};
                            }
                            if (args[2].equalsIgnoreCase("light_blue")) {
                                colorPreset = new int[] {173, 216, 230};
                            }
                            if (args[2].equalsIgnoreCase("dark_blue")) {
                                colorPreset = new int[] {0, 0, 139};
                            }
                            if (args[2].equalsIgnoreCase("indigo")) {
                                colorPreset = new int[] {75, 0, 130};
                            }
                            if (args[2].equalsIgnoreCase("light_indigo")) {
                                colorPreset = new int[] {111, 66, 193};
                            }
                            if (args[2].equalsIgnoreCase("dark_indigo")) {
                                colorPreset = new int[] {53, 0, 102};
                            }
                            if (args[2].equalsIgnoreCase("violet")) {
                                colorPreset = new int[] {238, 130, 238};
                            }
                            if (args[2].equalsIgnoreCase("light_violet")) {
                                colorPreset = new int[] {255, 187, 255};
                            }
                            if (args[2].equalsIgnoreCase("dark_violet")) {
                                colorPreset = new int[] {148, 0, 211};
                            }
                            if (args[2].equalsIgnoreCase("white")) {
                                colorPreset = new int[] {255, 255, 255};
                            }
                            if (args[2].equalsIgnoreCase("off_white")) {
                                colorPreset = new int[] {245, 245, 245};
                            }
                            if (args[2].equalsIgnoreCase("ivory")) {
                                colorPreset = new int[] {255, 255, 240};
                            }
                            if (args[2].equalsIgnoreCase("beige")) {
                                colorPreset = new int[] {245, 245, 220};
                            }
                            if (args[2].equalsIgnoreCase("snow")) {
                                colorPreset = new int[] {255, 250, 250};
                            }
                            if (args[2].equalsIgnoreCase("ghost_white")) {
                                colorPreset = new int[] {248, 248, 255};
                            }
                            if (args[2].equalsIgnoreCase("cream")) {
                                colorPreset = new int[] {255, 253, 208};
                            }
                            sendWledCommand(WLED_BASE_URL + "/win&T=1&R=" + colorPreset[0] + "&G=" + colorPreset[1] + "&B=" + colorPreset[2]);
                            sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Set the color of WLED instance to [" + ChatColor.RED + ChatColor.BOLD + colorPreset[0] + " " + ChatColor.GREEN + ChatColor.BOLD + colorPreset[1] + " " + ChatColor.BLUE + ChatColor.BOLD + colorPreset[2] + ChatColor.RESET + ChatColor.BOLD + "].");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "  color preset [desired preset] / color rgb <r> <g> <b> - set the color of WLED instance by using presets or by setting RGB channel values.\n");
                        }
                    }
                    if (args[1].equalsIgnoreCase("rgb")) {
                        if (args.length == 5) {
                            sendWledCommand(WLED_BASE_URL + "/win&T=1&R=" + args[2] + "&G=" + args[3] + "&B=" + args[4]);
                            sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Set the color of WLED instance to [" + ChatColor.RED + ChatColor.BOLD + args[2] + " " + ChatColor.GREEN + ChatColor.BOLD + args[3] + " " + ChatColor.BLUE + ChatColor.BOLD + args[4] + ChatColor.RESET + ChatColor.BOLD + "].");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "  color preset [desired preset] / color rgb <r> <g> <b> - set the color of WLED instance by using presets or by setting RGB channel values.\n");
                        }
                    }
                    if (args[1].equalsIgnoreCase("hex")) {
                        if (args.length == 3) {
                            sendWledCommand(WLED_BASE_URL + "/win&T=1&CL=h" + args[2]);
                            sender.sendMessage(ChatColor.GOLD+"[WLED Integration] " + ChatColor.RESET + ChatColor.BOLD + "Set the color of WLED instance to [" + ChatColor.GRAY + ChatColor.BOLD + args[2] + ChatColor.RESET + ChatColor.BOLD + "].");
                        } else {
                            sender.sendMessage(ChatColor.GOLD + "  color preset [desired preset] / color rgb <r> <g> <b> - set the color of WLED instance by using presets or by setting RGB channel values.\n");
                        }
                    }


                }
            } else {
                sender.sendMessage(ChatColor.GOLD+"[WLED Integration Plugin for Minecraft Java]\nmade by NIGHTFOXIE\n" +
                        " \n" +
                        "To show this help page, use /wled without any arguments.\n" +
                        " \n" +
                        "Usage of this plugin:\n" +
                        " - /wled <subcommands> [options]\n" +
                        " \n" +
                        "Available subcommands:\n" +
                        "  on - turn the WLED instance on.\n" +
                        "  off - turn the WLED instance off.\n" +
                        "  brightness - set the brightness of WLED instance between 0 and 255.\n" +
                        "  color preset [desired preset] / color rgb <r> <g> <b> - set the color of WLED instance by using presets or by setting RGB channel values.\n");

            }


        } else {
            sender.sendMessage(ChatColor.RED+"This command cannot be executed as a console.");
        }

        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("on", "off", "brightness", "color");
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("color")) {
                return Arrays.asList("preset", "rgb", "hex");
            }

        }
        if (args.length == 3) {
            if (args[1].equalsIgnoreCase("preset")) {
                return Arrays.asList(
                        "white",
                        "off_white",
                        "ivory",
                        "beige",
                        "snow",
                        "ghost_white",
                        "cream",
                        "black",
                        "gray",
                        "light_gray",
                        "red",
                        "light_red",
                        "dark_red",
                        "orange",
                        "light_orange",
                        "dark_orange",
                        "yellow",
                        "light_yellow",
                        "dark_yellow",
                        "green",
                        "light_green",
                        "dark_green",
                        "blue",
                        "light_blue",
                        "dark_blue",
                        "indigo",
                        "light_indigo",
                        "dark_indigo",
                        "violet",
                        "light_violet",
                        "dark_violet"
                );

            }
            if (args[1].equalsIgnoreCase("hex")) {
                return Arrays.asList("<hex>");
            }
            if (args[1].equalsIgnoreCase("rgb")) {
                return Arrays.asList("<r>");
            }
        }
        if (args.length == 4) {
            if (args[2].equalsIgnoreCase(args[2])) {
                return Arrays.asList("<g>");
            }
        }
        if (args.length == 5) {
            if (args[3].equalsIgnoreCase(args[3])) {
                return Arrays.asList("<b>");
            }
        }

        return new ArrayList<>();
    }
}
