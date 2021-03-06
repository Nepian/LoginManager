package com.Nepian.LoginManager.Listener.PlayerDataSave;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class XPSaving implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerDataSave(PlayerDataSaveEvent event) {

		if (!Config.PLAYERDATA__SAVE__XP.getBoolean()) {
			return;
		}

		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		data.setData(PATH_XP_LEVEL, player.getLevel());
		data.setData(PATH_XP_EXP, player.getExp());
		data.setData(PATH_XP_TOTALEXP, player.getTotalExperience());
	}
}
