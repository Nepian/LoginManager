package com.Nepian.LoginManager.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.Nepian.Breeze.Configuration.Annotation.PrecededBySpace;
import com.Nepian.LoginManager.LoginManager;

public class Logger {
	private static final LoginManager plugin = LoginManager.getPlugin();

	@PrecededBySpace
	public static String PLUGIN_ENABLE = "&d" + plugin.getName() + " v" + plugin.getDescription().getVersion() + " Enabled!";
	public static String PLUGIN_DISABLE = "&d" + plugin.getName() + " Disabled!";

	@PrecededBySpace
	public static String USERDATA_FOLDER_MAKING = "���[�U�f�[�^�t�H���_�𐶐����܂���";
	public static String USERDATA_UUID_LOAD = "UUID��ǂݍ��݂܂���";
	public static String USERDATA_LOAD = "���[�U�f�[�^��ǂݍ��݂܂���";

	public static void log(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&',
				"&3[&d" + LoginManager.getPlugin().getName() + "&3]&r " + msg);
		Bukkit.getServer().getConsoleSender().sendMessage(msg);
		return;
	}

	public static void debug(String msg) {
		Logger.log("&7[&eDEBUG&7]&r " + msg);
	}
}
