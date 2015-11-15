package com.Nepian.LoginManager.Listener.PlayerDataLoad;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class LocationLoading implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public static void onPlayerDataLoad(PlayerDataLoadEvent event) {

		if (!Config.PLAYERDATA__LOAD__LOCATION.getBoolean()) {
			return;
		}

		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		if (!data.hasData(PATH_LOCATION)) {
			data.setData(PATH_LOCATION, player.getLocation());
		} else {
			player.teleport((Location) data.get(PATH_LOCATION));
		}
	}
}
