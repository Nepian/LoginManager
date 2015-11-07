package com.Nepian.LoginManager.Listener.Player;

import static org.bukkit.event.EventPriority.*;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Nepian.LoginManager.LoginManager;
import com.Nepian.LoginManager.Events.UserdataLoadEvent;
import com.Nepian.LoginManager.Userdata.Userdata;
import com.Nepian.LoginManager.Userdata.UserdataManager;

public class PlayerJoin implements Listener {

	@EventHandler(priority = MONITOR, ignoreCancelled = true)
	public static void onPlayerJoin(final PlayerJoinEvent event) {

		Bukkit.getScheduler().runTaskAsynchronously(LoginManager.getPlugin(), new Runnable() {

			@Override
			public void run() {
				Player player = event.getPlayer();
				UUID uuid = player.getUniqueId();
				Userdata userdata = UserdataManager.getUserdata(uuid);

				if (userdata == null) {
					userdata = new Userdata(uuid);
					UserdataManager.put(uuid, userdata);
				}

				UserdataLoadEvent loadEvent = new UserdataLoadEvent(player, userdata);

				LoginManager.callEvent(loadEvent);
				userdata.save();
			}

		});

	}
}
