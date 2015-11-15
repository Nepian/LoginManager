package com.Nepian.LoginManager.Configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.Nepian.LoginManager.LoginManager;

public enum Messages {
	PREFIX("&3[&e{plugin}&3]&r ");

	private static final LoginManager plugin;
	private String message;

	static {
		plugin = LoginManager.getPlugin();
	}

	/* Constructor ----------------------------------------------------------*/

	Messages(String message) {
		this.message = message;
	}

	/* Methods --------------------------------------------------------------*/

	public String get() {
		return this.message;
	}

	public static void sendPrefixMessage(CommandSender sender, String message) {
		sendMessage(sender, prefix(message));
	}

	public static void load(File file) {
		read(file);
		save(file);
	}

	public static void save(File file) {
		write(file);
	}

	/* Private Methods ------------------------------------------------------*/

	private static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}

	private static String prefix(String message) {
		return PREFIX.get().replace("{plugin}", plugin.getName()) + message;
	}

	private String toPath() {
		return this.toString().toLowerCase().replace("__", ".");
	}

	private static void read(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Messages key : values()) {
			String path = key.toPath();

			if (conf.contains(path)) {
				key.message = (String) conf.get(path);
			}
		}

		Logger.debug(Logger.LANG_LOAD.get());
	}

	private static void write(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Messages key : values()) {
			conf.set(key.toPath(), key.message);
		}

		try {
			conf.save(file);
			Logger.debug(Logger.LANG_WRITE.get());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
