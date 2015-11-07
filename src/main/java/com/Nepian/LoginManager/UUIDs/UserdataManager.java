package com.Nepian.LoginManager.UUIDs;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Configuration.Logger;

public class UserdataManager {
	private static Map<UUID, Userdata> userdatas = new HashMap<UUID, Userdata>();

	/**
	 * UUIDからデータを新規に追加する
	 * @param uuid 追加するUUID
	 */
	public static void put(UUID uuid) {
		put(uuid, new Userdata(uuid));
	}

	public static void put(Userdata userdata) {
		put(userdata.getUUID(), userdata);
	}

	public static void put(UUID uuid, Userdata userdata) {
		userdatas.put(uuid, userdata);
	}

	public static Userdata getUserdata(UUID uuid) {
		return userdatas.get(uuid);
	}

	public static void load() {
		for (File file : LoginManager.getUserdataFolder().listFiles()) {
			put(new Userdata(file));
		}
		Logger.log(Logger.USERDATA_LOAD);
	}

	public static void save() {
		for (Userdata userdata : userdatas.values()) {
			userdata.save();
		}
		Logger.log(Logger.USERDATA_SAVE_ALL);
	}
}
