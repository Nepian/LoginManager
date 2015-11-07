package com.Nepian.LoginManager.Listener.UserdataSave;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.UserdataSaveEvent;
import com.Nepian.LoginManager.UUIDs.Userdata;
import com.Nepian.LoginManager.UUIDs.UserdataPath;

public class NameSaving implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onUserdataSave(final UserdataSaveEvent event) {
		final Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		userdata.set(UserdataPath.NAME, player.getName());
	}
}
