package com.Nepian.LoginManager.Listener.PlayerDataLoad;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Configuration.Properties;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class NameLoading implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerDataLoad(PlayerDataLoadEvent event) {

		if (!Config.PLAYERDATA__LOAD__NAME.getBoolean()) {
			return;
		}

		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		data.setData(Properties.NAME_PATH, player.getName());
	}
}
