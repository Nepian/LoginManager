package com.Nepian.LoginManager.Listener.PlayerDataSave;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.PlayerDataSaveEvent;

public class PlayerDataSaveWriting implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public static void onPlayerDataSave(final PlayerDataSaveEvent event) {
		event.getPlayerData().write();
	}
}
