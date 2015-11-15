package com.Nepian.LoginManager.Listener.PlayerDataSave;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Configuration.Properties;
import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class LocationSaving implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerDataSave(PlayerDataSaveEvent event) {

		if (!Config.PLAYERDATA__SAVE__LOCATION.getBoolean()) {
			return;
		}

		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		data.setData(Properties.PATH_LOCATION, player.getLocation());
	}
}
