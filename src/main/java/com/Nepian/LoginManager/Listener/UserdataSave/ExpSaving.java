package com.Nepian.LoginManager.Listener.UserdataSave;

import static com.Nepian.LoginManager.Configuration.Properties.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.LoginManager.Events.UserdataSaveEvent;
import com.Nepian.LoginManager.Userdata.Userdata;
import com.Nepian.LoginManager.Utils.PlayerUtil;

public class ExpSaving implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onUserdataSave(UserdataSaveEvent event) {
		Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		userdata.set(EXP_PATH, PlayerUtil.getExp(player));
	}
}
