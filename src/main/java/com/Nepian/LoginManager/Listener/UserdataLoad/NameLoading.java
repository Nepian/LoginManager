package com.Nepian.LoginManager.Listener.UserdataLoad;

import static org.bukkit.event.EventPriority.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.UserdataLoadEvent;
import com.Nepian.LoginManager.Userdata.Userdata;
import com.Nepian.LoginManager.Userdata.UserdataPath;

public class NameLoading implements Listener {

	@EventHandler(priority = MONITOR)
	public static void onUserdataLoad(UserdataLoadEvent event) {
		Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		if (!userdata.has(UserdataPath.NAME)) {
			userdata.set(UserdataPath.NAME, player.getName());
		}
	}
}
