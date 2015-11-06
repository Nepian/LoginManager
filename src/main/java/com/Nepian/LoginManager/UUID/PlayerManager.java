package com.Nepian.LoginManager.UUID;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PlayerManager {
	private static Map<UUID, Player> loginPlayers = new HashMap<UUID, Player>();

	public static void loginPlayer(Player player) {
		loginPlayers.put(player.getUniqueId(), player);
	}

	public static void logoutPlayer(Player player) {
		loginPlayers.remove(player.getUniqueId());
	}

	public static Map<UUID, Player> getLoginPlayers() {
		return loginPlayers;
	}
}
