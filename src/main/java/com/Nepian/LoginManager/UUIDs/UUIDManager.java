package com.Nepian.LoginManager.UUIDs;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.Nepian.LoginManager.Configuration.Logger;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class UUIDManager {
	private static BiMap<UUID, String> uuids = HashBiMap.create();

	/* Methods --------------------------------------------------------------*/

	public static void addUUID(UUID uuid) {
		UUIDManager.addUUID(uuid, Bukkit.getOfflinePlayer(uuid).getName());
	}

	public static void addUUID(UUID uuid, String name) {
		uuids.put(uuid, name);
	}

	public static void load() {
		for (OfflinePlayer offPlayer : Bukkit.getOfflinePlayers()) {
			UUID uuid = offPlayer.getUniqueId();
			UUIDManager.addUUID(uuid);
		}

		Logger.log(Logger.USERDATA_UUID_LOAD);
	}
}
