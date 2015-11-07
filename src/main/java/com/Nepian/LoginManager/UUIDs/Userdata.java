package com.Nepian.LoginManager.UUIDs;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.Nepian.LoginManager.LoginManager;

public class Userdata {
	private UUID uuid;
	private File file;
	private FileConfiguration dataFile;

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

	/* Methods --------------------------------------------------------------*/

	private void loadUserDataFile() {
		File dataFolder = LoginManager.getUserDataFolder();
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
		}
	}

	public void setData(String path, Object value) {
		dataFile.set(path, value);
		try {
			dataFile.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getInt(String path) {
		return dataFile.getInt(path);
	}

	public boolean hasPath(String path) {
		return dataFile.contains(path);
	}

	/* Getter ---------------------------------------------------------------*/

	public UUID getUUID() { return uuid; }

	public FileConfiguration getDataFile() { return dataFile; }

	/* Setter ---------------------------------------------------------------*/
}
