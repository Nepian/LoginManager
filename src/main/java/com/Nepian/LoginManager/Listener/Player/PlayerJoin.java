package com.Nepian.LoginManager.Listener.Player;

import static org.bukkit.event.EventPriority.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;
import com.Nepian.LoginManager.PlayerData.PlayerData;
import com.Nepian.LoginManager.PlayerData.PlayerDataManager;

public class PlayerJoin implements Listener {

	@EventHandler(priority = MONITOR, ignoreCancelled = true)
	public static void onPlayerJoin(final PlayerJoinEvent event) {

		Bukkit.getScheduler().runTaskAsynchronously(LoginManager.getPlugin(), new Runnable() {

			@Override
			public void run() {
				Player player = event.getPlayer();
				PlayerData data = PlayerDataManager.get(player, true);
				PlayerDataLoadEvent loadEvent = new PlayerDataLoadEvent(player, data);

				LoginManager.callEvent(loadEvent);
			}

		});

	}
}
