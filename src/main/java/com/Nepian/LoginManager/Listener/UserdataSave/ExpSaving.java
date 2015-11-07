package com.Nepian.LoginManager.Listener.UserdataSave;

import static com.Nepian.LoginManager.UUIDs.UserdataPath.*;
import static org.bukkit.event.EventPriority.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.Nepian.Breeze.Utils.PlayerUtil;
import com.Nepian.LoginManager.Events.UserdataSaveEvent;
import com.Nepian.LoginManager.UUIDs.Userdata;

public class ExpSaving implements Listener {

	@EventHandler(priority = LOWEST)
	public static void onUserdataSave(UserdataSaveEvent event) {
		Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		userdata.set(EXP, PlayerUtil.getExp(player));
	}
}
