package com.Nepian.LoginManager.PlayerData;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {
	private Map<String, Object> playerData;
	private File file;

	/* Constructor ----------------------------------------------------------*/

	public PlayerData(File file) {
		this.file = file;
	}

	/* Methods --------------------------------------------------------------*/

	public boolean hasData(String key) {
		return this.get(key) != null;
	}

	public void setData(String key, Object value) {
		this.playerData.put(key, value);
	}

	public int getInt(String key) {
		return (int) this.get(key);
	}

	public String getString(String key) {
		return (String) this.get(key);
	}

	public PlayerData read() {
		FileConfiguration data = YamlConfiguration.loadConfiguration(this.file);

		this.playerData = data.getValues(true);

		return this;
	}

	public PlayerData write() {
		YamlConfiguration data = YamlConfiguration.loadConfiguration(this.file);

		for (String key : this.playerData.keySet()) {
			data.set(key, this.get(key));
		}

		try {
			data.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return this;
	}

	/* Private Methods ------------------------------------------------------*/

	private Object get(String key) {
		return this.playerData.get(key);
	}
}
