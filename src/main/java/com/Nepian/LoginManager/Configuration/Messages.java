package com.Nepian.LoginManager.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Messages {
	public static String prefix = ChatColor.DARK_GREEN + "[LoginManager] " + ChatColor.RESET;

	public static String prefix(String message) {
		return prefix + message;
	}

	public static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}
