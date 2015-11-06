package com.Nepian.LoginManager.Listener.Player;

import static org.bukkit.event.EventPriority.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnect implements Listener {

	@EventHandler(priority = MONITOR, ignoreCancelled = true)
	public static void onPlayerConnect(final PlayerJoinEvent event) {

	}
}
