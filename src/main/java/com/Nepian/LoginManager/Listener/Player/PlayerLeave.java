package com.Nepian.LoginManager.Listener.Player;

import static org.bukkit.event.EventPriority.*;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.Nepian.LoginManager.LoginManager;

public class PlayerLeave implements Listener {

	@EventHandler(priority = LOWEST)
	public static void onPlayerLeave(final PlayerQuitEvent event) {

		Bukkit.getScheduler().runTaskAsynchronously(LoginManager.getPlugin(), new Runnable() {

			@Override
			public void run() {
			}

		});

	}
}
