package com.Nepian.LoginManager.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.Nepian.Breeze.Configuration.Annotation.PrecededBySpace;
import com.Nepian.LoginManager.LoginManager;

public class Logger {
	private static final LoginManager plugin = LoginManager.getPlugin();

	@PrecededBySpace
	public static String PREFIX = "&3[&e" + LoginManager.getPlugin().getName() + "&3] ";

	@PrecededBySpace
	public static String PLUGIN_ENABLE = plugin.getName() + " v" + plugin.getDescription().getVersion() + " Enabled!";
	public static String PLUGIN_DISABLE = plugin.getName() + " Disabled!";

	@PrecededBySpace
	public static String USERDATA_FOLDER_MAKING = "���[�U�f�[�^�t�H���_�𐶐����܂���";
	public static String USERDATA_UUID_LOAD = "UUID��ǂݍ��݂܂���";
	public static String USERDATA_LOAD = "���[�U�f�[�^��ǂݍ��݂܂���";
	public static String USERDATA_SAVE_ALL = "���[�U�f�[�^��S�ĕۑ����܂���";

	public static void log(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', PREFIX + msg);
		Bukkit.getServer().getConsoleSender().sendMessage(msg);
		return;
	}

	public static void debug(String msg) {
		Logger.log("&7[&eDEBUG&7]&r " + msg);
	}
}
