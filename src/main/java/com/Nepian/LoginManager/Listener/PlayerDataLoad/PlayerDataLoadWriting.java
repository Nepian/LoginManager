package com.Nepian.LoginManager.Listener.PlayerDataLoad;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Events.PlayerDataLoadEvent;

public class PlayerDataLoadWriting implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public static void onPlayerDataLoad(final PlayerDataLoadEvent event) {
		Bukkit.getScheduler().runTaskAsynchronously(LoginManager.getPlugin(),
			new Runnable() {
				public void run() {
					event.getPlayerData().write();
				}
			}
		);
	}
}
