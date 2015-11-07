package com.Nepian.LoginManager.Listener.UserdataLoad;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.UserdataLoadEvent;
import com.Nepian.LoginManager.Userdata.Userdata;

public class NameLoading implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public static void onUserdataLoad(UserdataLoadEvent event) {
		Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		if (!userdata.has(NAME_PATH)) {
			userdata.set(NAME_PATH, player.getName());
		}
	}
}
