package com.Nepian.LoginManager.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.Nepian.Breeze.Configuration.Annotation.PrecededBySpace;
import com.Nepian.LoginManager.LoginManager;

public class Messages {
	@PrecededBySpace
	public static String PREFIX = "&3[&e" + LoginManager.getPlugin().getName() + "&3]&r ";

	public static String prefix(String message) {
		return PREFIX + message;
	}

	public static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}
