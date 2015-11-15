package com.Nepian.LoginManager.Listener.PlayerDataLoad;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Configuration.Config;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;

public class XPLoading implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerDataLoad(PlayerDataLoadEvent event) {

		if (!Config.PLAYERDATA__LOAD__XP.getBoolean()) {
			return;
		}

		Player player = event.getPlayer();
		PlayerData data = event.getPlayerData();

		if (!data.hasData(XP_LEVEL_PATH)) {
			data.setData(XP_LEVEL_PATH, player.getLevel());
		} else {
			player.setLevel(data.getInt(XP_LEVEL_PATH));
		}

		if (!data.hasData(XP_EXP_PATH)) {
			data.setData(XP_EXP_PATH, player.getExp());
		} else {
			player.setExp(data.getFloat(XP_EXP_PATH));
		}

		if (!data.hasData(XP_TOTALEXP_PATH)) {
			data.setData(XP_TOTALEXP_PATH, player.getTotalExperience());
		} else {
			player.setTotalExperience(data.getInt(XP_TOTALEXP_PATH));
		}
	}
}
