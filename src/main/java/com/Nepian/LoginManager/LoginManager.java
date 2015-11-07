package com.Nepian.LoginManager;

import static com.Nepian.LoginManager.Configuration.Logger.*;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.Breeze.Configuration.Configuration;
import com.Nepian.LoginManager.Configuration.Logger;
import com.Nepian.LoginManager.Configuration.Messages;
import com.Nepian.LoginManager.Configuration.Properties;
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
		userdataFolder = loadFolder("userdata");
		plugin = this;
	}

	/* Methods --------------------------------------------------------------*/

	public void onEnable() {
		Configuration.pairFileAndClass(loadFile("config.yml"), Properties.class);
		Configuration.pairFileAndClass(loadFile("log-message.yml"), Logger.class);
		Configuration.pairFileAndClass(loadFile("local.yml"), Messages.class);

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

	public static File loadFile(String string) {
		File file = new File(dataFolder, string);

		return loadFile(file);
	}

	public static File loadFile(File file) {
		if (!file.exists()) {
			try {
				if (file.getParent() != null) {
					file.getParentFile().mkdirs();
				}

				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}

	public static File loadFolder(String string) {
		File file = new File(dataFolder, string);

		return loadFolder(file);
	}

	public static File loadFolder(File file) {
		if (!file.exists()) {
			if (file.getParent() != null) {
				file.getParentFile().mkdirs();
			}
			file.mkdir();
		}

		return file;
	}

	/* Private Methods ------------------------------------------------------*/

	/* Event registers ------------------------------------------------------*/

	private void registerEvents() {
		registerUserdatataLoadEvent();
		registerUserdataSaveEvent();

		registerEvent(new PlayerJoin());
		registerEvent(new PlayerQuit());
	}

	private void registerEvent(Listener listener) {
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
