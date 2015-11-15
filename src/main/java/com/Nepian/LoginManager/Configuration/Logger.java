package com.Nepian.LoginManager.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.Nepian.LoginManager.LoginManager;

public enum Logger {
	PREFIX("&3[&e{plugin}&3]&e "),
	PLUGIN_ENABLE("{plugin} v{version} Enabled!"),
	PLUGIN_DISABLE("{plugin} Disabled!"),

	PLAYERDATA_READ("[&2Read&r] UUID.yml -> PlayerData"),
	PLAYERDATA_WRITE("[&3WRITE&r] PlayerData -> UUID.yml"),
	PLAYERDATA_READ_ALL("[&2Read&r] All UUID.yml -> All PlayerData"),
	PLAYERDATA_WRITE_ALL("[&3WRITE&r] All PlayerData -> All UUID.yml"),

	CONFIG_LOAD("[&2Read&r] config.yml -> Config"),
	CONFIG_WRITE("[&3WRITE&r] Config -> config.yml"),

	LANG_LOAD("[&2Read&r] lang-xx.yml -> Messages"),
	LANG_WRITE("[&3WRITE&r] Messages -> lang-xx.yml");

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
