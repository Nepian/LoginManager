package com.Nepian.LoginManager;

import static com.Nepian.LoginManager.Configuration.Logger.*;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.LoginManager.Configuration.Logger;
import com.Nepian.LoginManager.Listener.Player.PlayerJoin;
import com.Nepian.LoginManager.Listener.Player.PlayerLeave;
import com.Nepian.LoginManager.Listener.UserdataLoad.ExpLoading;
import com.Nepian.LoginManager.UUIDs.UUIDManager;
import com.Nepian.LoginManager.UUIDs.UserdataManager;

public class LoginManager extends JavaPlugin {
	private static LoginManager plugin;
	private static File dataFolder;
	private static File userDataFolder;

	public LoginManager() {
		dataFolder = getDataFolder();
		plugin = this;
	}

	public void onEnable() {
		saveDefaultConfig();

		registerEvents();

		userDataFolder = new File(dataFolder, "userdata");
		if (!userDataFolder.exists()) {
			userDataFolder.mkdirs();
			Logger.log(USERDATA_FOLDER_MAKING);
		}

		UUIDManager.load();
		UserdataManager.load();

		Logger.log(PLUGIN_ENABLE);
	}

	public void onDisable() {
		Logger.log(PLUGIN_DISABLE);
	}

	/* Event registers ------------------------------------------------------*/

	private void registerEvents() {
		registerUserdatataLoadEvent();

		registerEvent(new PlayerJoin());
		registerEvent(new PlayerLeave());
	}

	public void registerEvent(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}

	private void registerUserdatataLoadEvent() {
		registerEvent(new ExpLoading());
	}

	/*-----------------------------------------------------------------------*/

	public static LoginManager getPlugin() {
		return plugin;
	}

	public static File getUserDataFolder() {
		return userDataFolder;
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}
}
