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

		if (!data.hasData(PATH_XP_LEVEL)) {
			data.setData(PATH_XP_LEVEL, player.getLevel());
		} else {
			player.setLevel(data.getInt(PATH_XP_LEVEL));
		}

		if (!data.hasData(PATH_XP_EXP)) {
			data.setData(PATH_XP_EXP, player.getExp());
		} else {
			player.setExp(data.getFloat(PATH_XP_EXP));
		}

		if (!data.hasData(PATH_XP_TOTALEXP)) {
			data.setData(PATH_XP_TOTALEXP, player.getTotalExperience());
		} else {
			player.setTotalExperience(data.getInt(PATH_XP_TOTALEXP));
		}
	}
}
