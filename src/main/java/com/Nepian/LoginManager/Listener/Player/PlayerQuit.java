package com.Nepian.LoginManager.Listener.Player;

import static org.bukkit.event.EventPriority.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;
import com.Nepian.LoginManager.PlayerData.PlayerDataManager;

public class PlayerQuit implements Listener {

	@EventHandler(priority = LOWEST)
	public static void onPlayerLeave(final PlayerQuitEvent event) {

		Bukkit.getScheduler().runTaskAsynchronously(LoginManager.getPlugin(), new Runnable() {

			@Override
			public void run() {
				Player player = event.getPlayer();
				PlayerData data = PlayerDataManager.get(player, true);
				PlayerDataSaveEvent saveEvent = new PlayerDataSaveEvent(player, data);

				LoginManager.callEvent(saveEvent);
			}

		});

	}
}
