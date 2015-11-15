package com.Nepian.LoginManager.Listener.PlayerDataSave;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class XPSaving implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerDataSave(PlayerDataSaveEvent event) {
		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		data.setData(XP_LEVEL_PATH, player.getLevel());
		data.setData(XP_EXP_PATH, player.getExp());
		data.setData(XP_TOTALEXP_PATH, player.getTotalExperience());
	}
}
