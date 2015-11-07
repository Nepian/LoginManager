package com.Nepian.LoginManager.Listener.UserdataLoad;

import static com.Nepian.LoginManager.UUIDs.UserdataPath.*;
import static org.bukkit.event.EventPriority.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.Nepian.Breeze.Utils.PlayerUtil;
import com.Nepian.LoginManager.Events.UserdataLoadEvent;
import com.Nepian.LoginManager.UUIDs.Userdata;

public class ExpLoading implements Listener {

	@EventHandler(priority = MONITOR)
	public static void onUserdataLoad(UserdataLoadEvent event) {
		Player player = event.getPlayer();
		Userdata userdata = event.getUserdata();

		if (!userdata.hasPath(EXP_PATH)) {
			userdata.setData(EXP_PATH, PlayerUtil.getExp(player));
		}

		PlayerUtil.setExp(player, userdata.getInt(EXP_PATH));
	}
}
