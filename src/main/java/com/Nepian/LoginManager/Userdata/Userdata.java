package com.Nepian.LoginManager.Userdata;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.Nepian.LoginManager.LoginManager;

public class Userdata {
	private UUID uuid;
	private File file;
	private FileConfiguration dataFile;

	private Map<String, Object> data;

	/* Constructor ----------------------------------------------------------*/

	public Userdata(UUID uuid) {
		this.uuid = uuid;
		this.loadUserDataFile();
		this.loadUserData();
	}

	public Userdata(File file) {
		this.uuid = UUID.fromString(file.getName().replace(".yml", ""));
		this.file = file;
		this.loadUserData();
	}

	/* Public Methods -------------------------------------------------------*/

	public boolean has(String key) {
		return data.containsKey(key);
	}

	public Object get(String key) {
		return data.get(key);
	}

	public int getInt(String key) {
		return (int) get(key);
	}

	public String getString(String key) {
		return (String) get(key);
	}

	public void set(String key, Object value) {
		data.put(key, value);
	}

	public void save(String key) {
		dataFile.set(key, data.get(key));
		try {
			dataFile.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		for (String key : data.keySet()) {
			save(key);
		}
	}

	/* Private Methods ------------------------------------------------------*/

	private void loadUserDataFile() {
		File dataFolder = LoginManager.getUserdataFolder();
		String fileName = uuid.toString() + ".yml";

		file = new File(dataFolder, fileName);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadUserData() {
		if (file.exists()) {
			dataFile = YamlConfiguration.loadConfiguration(file);
			setData(dataFile.getValues(true));
		}
	}

	/* Getter ---------------------------------------------------------------*/

	public UUID getUUID() { return uuid; }

	public FileConfiguration getDataFile() { return dataFile; }

	public Map<String, Object> getData() { return data; }

	/* Setter ---------------------------------------------------------------*/

	private void setData(Map<String, Object> data) { this.data = data; }
}
