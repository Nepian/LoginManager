package com.Nepian.LoginManager.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.Nepian.LoginManager.LoginManager;

public enum Logger {
	PREFIX("&3[&e{plugin}&3]&e "),
	PLUGIN_ENABLE("{plugin} v{version} Enabled!"),
	PLUGIN_DISABLE("{plugin} Disabled!"),

	PLAYERDATA_READ("[READ] UUID.yml -> PlayerData"),
	PLAYERDATA_WRITE("[WRITE] PlayerData -> UUID.yml"),
	PLAYERDATA_READ_ALL("[READ] All UUID.yml -> All PlayerData"),
	PLAYERDATA_WRITE_ALL("[WRITE] All PlayerData -> All UUID.yml"),

	CONFIG_LOAD("[READ] config.yml -> Config"),
	CONFIG_WRITE("[WRITE] Config -> config.yml"),

	LANG_LOAD("[READ] lang-xx.yml -> Messages"),
	LANG_WRITE("[WRITE] Messages -> lang-xx.yml");

	private static final LoginManager plugin;
	private String message;

	static {
		plugin = LoginManager.getPlugin();
	}

	Logger(String message) {
		this.message = message;
	}

	public String get() {
		this.message =
			this.message
			.replace("{plugin}", plugin.getName())
			.replace("{version}", plugin.getDescription().getVersion());
		return this.message;
	}

	public static void log(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', PREFIX.get() + msg);
		Bukkit.getServer().getConsoleSender().sendMessage(msg);
		return;
	}

	public static void debug(String msg) {
		if (Config.DEBUG.getBoolean()) {
			Logger.log("&7[&eDEBUG&7]&r " + msg);
		}
	}
}
