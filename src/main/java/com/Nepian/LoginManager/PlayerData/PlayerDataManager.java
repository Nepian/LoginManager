package com.Nepian.LoginManager.PlayerData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Configuration.Files;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;
import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;

public class PlayerDataManager {
	private static final File playerDataFolder = Files.FOLDER_PLAYERDATA;
	private static Map<UUID, PlayerData> playerDatas;

	/* Methods --------------------------------------------------------------*/

	public static void load() {
		readPlayerData(playerDataFolder);
		loadPlayerData();
	}

	public static void save() {
		savePlayerData();
		writePlayerData(playerDataFolder);
	}

	public static void reload() {
		save();
		load();
	}

	public static boolean register(Player player) {
		return registerPlayerData(player.getUniqueId());
	}

	/**
	 * 指定したプレイヤーの PlayerData を取得する
	 * @param player PlayerData を取得するプレイヤー
	 * @param regist true:プレイヤーが存在しない場合に新しく追加する
	 * @return regist:false で PlayerData が存在しない場合は null を返す
	 */
	public static PlayerData get(Player player, boolean regist) {
		return get(player.getUniqueId(), regist);
	}

	/* Private Methods ------------------------------------------------------*/

	private static void readPlayerData(File folder) {
		Map<UUID, PlayerData> datas = new HashMap<UUID, PlayerData>();

		for (File file : folder.listFiles()) {
			UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));
			PlayerData data = new PlayerData(file);

			datas.put(uuid, data);
		}

		playerDatas = datas;
	}

	private static void writePlayerData(File folder) {

		for (File file : folder.listFiles()) {
			UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));

			playerDatas.get(uuid).write(file);
		}
	}

	private static void loadPlayerData() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			PlayerData data = playerDatas.get(player.getUniqueId());
			LoginManager.callEvent(new PlayerDataLoadEvent(player, data));
		}
	}

	private static void savePlayerData() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			PlayerData data = playerDatas.get(player.getUniqueId());
			LoginManager.callEvent(new PlayerDataSaveEvent(player, data));
		}
	}

	private static boolean registerPlayerData(UUID uuid) {
		String fileName = uuid.toString() + ".yml";
		File file = new File(playerDataFolder, fileName);

		if (!file.exists()) {
			try {
				if (file.getParent() != null) {
					file.getParentFile().mkdirs();
				}

				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		PlayerData data = new PlayerData(file);

		playerDatas.put(uuid, data);

		return true;
	}

	private static PlayerData get(UUID uuid, boolean regist) {
		PlayerData data = playerDatas.get(uuid);

		if (data != null) {
			return data;
		}

		if (!regist) {
			return data;
		}

		registerPlayerData(uuid);

		return playerDatas.get(uuid);
	}
}
