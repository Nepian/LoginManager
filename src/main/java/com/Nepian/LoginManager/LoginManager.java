package com.Nepian.LoginManager;

import static com.Nepian.LoginManager.Configuration.Files.*;
import static com.Nepian.LoginManager.Configuration.Logger.*;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Configuration.Logger;
import com.Nepian.LoginManager.Configuration.Messages;
import com.Nepian.LoginManager.Listener.PlayerDataLoad.LocationLoading;
import com.Nepian.LoginManager.Listener.PlayerDataLoad.NameLoading;
import com.Nepian.LoginManager.Listener.PlayerDataLoad.PlayerDataLoadWriting;
import com.Nepian.LoginManager.Listener.PlayerDataLoad.XPLoading;
import com.Nepian.LoginManager.Listener.PlayerDataSave.LocationSaving;
import com.Nepian.LoginManager.Listener.PlayerDataSave.PlayerDataSaveWriting;
import com.Nepian.LoginManager.Listener.PlayerDataSave.XPSaving;
import com.Nepian.LoginManager.PlayerData.PlayerDataManager;

public class LoginManager extends JavaPlugin {
	private static LoginManager plugin;

	public LoginManager() {
		plugin = this;
	}

	/* Methods --------------------------------------------------------------*/

	public void onEnable() {
		Config.load(FILE_CONFIG);
		Messages.load(FILE_LANG);
		PlayerDataManager.load();
		registerEvents();

		Logger.log(PLUGIN_ENABLE.get());
	}

	public void onDisable() {
		Config.save(FILE_CONFIG);
		Messages.save(FILE_LANG);
		PlayerDataManager.save();

		this.getServer().getScheduler().cancelTasks(this);

		Logger.log(PLUGIN_DISABLE.get());
	}

	public static void callEvent(Event event) {
		Logger.debug("[&dEvent&r] " + event.getEventName());
		Bukkit.getPluginManager().callEvent(event);
	}

	/* Event registers ------------------------------------------------------*/

	private void registerEvents() {
		registerPlayerDatataLoadEvent();
		registerPlayerDataSaveEvent();
		registerEvent(new PlayerDataManager());
	}

	private void registerPlayerDatataLoadEvent() {
		registerEvent(new NameLoading());
		registerEvent(new XPLoading());
		registerEvent(new LocationLoading());
		registerEvent(new PlayerDataLoadWriting());
	}

	private void registerPlayerDataSaveEvent() {
		registerEvent(new XPSaving());
		registerEvent(new LocationSaving());
		registerEvent(new PlayerDataSaveWriting());
	}

	private void registerEvent(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}

	/* Getter ---------------------------------------------------------------*/

	public static LoginManager getPlugin() {
		return plugin;
	}
}
