package com.Nepian.LoginManager;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class LoginManager extends JavaPlugin {
	private static LoginManager plugin;
	private static File dataFolder;
	private static File userDataFolder;

	public LoginManager() {
		dataFolder = getDataFolder();
		plugin = this;
	}

	public void onEnable() {
		userDataFolder = new File(dataFolder, "userdata");
		if (userDataFolder.exists()) {
			userDataFolder.mkdirs();
		}
	}

	public void onDisable() {

	}

	public static LoginManager getPlugin() {
		return plugin;
	}

	public static File getPlayerDataFolder() {
		return userDataFolder;
	}
}
