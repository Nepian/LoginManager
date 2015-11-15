package com.Nepian.LoginManager.Configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Config {
	PLAYERDATA__LOAD__NAME(true),
	PLAYERDATA__LOAD__XP(true),
	PLAYERDATA__SAVE__XP(true),
	LANG("lang-jp.yml"),
	DEBUG(true);

	private Object value;

	/* Constructor ----------------------------------------------------------*/

	Config(Object value) {
		this.value = value;
	}

	/* Methods --------------------------------------------------------------*/

	public boolean getBoolean() {
		return (boolean) this.get();
	}

	public String getString() {
		return (String) this.get();
	}

	public static void load(File file) {
		read(file);
		save(file);
	}

	public static void save(File file) {
		write(file);
	}

	/* Private Methods ------------------------------------------------------*/

	private Object get() {
		return this.value;
	}

	private String toPath() {
		return this.toString().toLowerCase().replace("__", ".");
	}

	private static void read(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Config key : values()) {
			String path = key.toPath();

			if (conf.contains(path)) {
				key.value = conf.get(path);
			}
		}

		Logger.debug(Logger.CONFIG_LOAD.get());
	}

	private static void write(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Config key : values()) {
			conf.set(key.toPath(), key.value);
		}

		try {
			conf.save(file);
			Logger.debug(Logger.CONFIG_WRITE.get());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
