package com.Nepian.LoginManager;

import static com.Nepian.LoginManager.Configuration.Logger.*;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.LoginManager.Configuration.Logger;
import com.Nepian.LoginManager.Listener.Player.PlayerJoin;
import com.Nepian.LoginManager.Listener.Player.PlayerQuit;
import com.Nepian.LoginManager.Listener.UserdataLoad.ExpLoading;
import com.Nepian.LoginManager.Listener.UserdataLoad.NameLoading;
import com.Nepian.LoginManager.Listener.UserdataSave.ExpSaving;
import com.Nepian.LoginManager.Userdata.UserdataManager;

public class LoginManager extends JavaPlugin {
	private static LoginManager plugin;
	private static File dataFolder;
	private static File userdataFolder;

	public LoginManager() {
		dataFolder = getDataFolder();
		plugin = this;
	}

	/* Methods --------------------------------------------------------------*/

	public void onEnable() {
		saveDefaultConfig();
		loadUserdataFolder();

		registerEvents();
		UserdataManager.load();

		Logger.log(PLUGIN_ENABLE);
	}

	public void onDisable() {
		UserdataManager.save();

		Logger.log(PLUGIN_DISABLE);
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}

	/* Private Methods ------------------------------------------------------*/

	private static void loadUserdataFolder() {
		userdataFolder = new File(dataFolder, "userdata");
		if (!userdataFolder.exists()) {
			userdataFolder.mkdirs();
			Logger.log(USERDATA_FOLDER_MAKING);
		}
	}

	/* Event registers ------------------------------------------------------*/

	private void registerEvents() {
		registerUserdatataLoadEvent();
		registerUserdataSaveEvent();

		registerEvent(new PlayerJoin());
		registerEvent(new PlayerQuit());
	}

	public void registerEvent(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}

	private void registerUserdatataLoadEvent() {
		registerEvent(new NameLoading());
		registerEvent(new ExpLoading());
	}

	private void registerUserdataSaveEvent() {
		registerEvent(new ExpSaving());
	}

	/* Getter ---------------------------------------------------------------*/

	public static LoginManager getPlugin() { return plugin; }

	public static File getUserdataFolder() { return userdataFolder; }
}
