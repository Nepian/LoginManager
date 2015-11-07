package com.Nepian.LoginManager.Listener.UserdataCreate;

import static com.Nepian.LoginManager.UUIDs.UserdataPath.*;
import static org.bukkit.event.EventPriority.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.UserdataCreateEvent;
import com.Nepian.LoginManager.UUIDs.Userdata;

public class ExpSetting implements Listener {

	@EventHandler(priority = MONITOR)
	public static void onUserdataCreate(UserdataCreateEvent event) {
		Userdata userdata = event.getUserdata();

		if (userdata.hasPath(EXP_PATH)) {
			return;
		}

		userdata.setData(EXP_PATH, 0);
	}
}
