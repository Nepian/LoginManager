package com.Nepian.LoginManager.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Nepian.LoginManager.UUIDs.Userdata;

public class UserdataCreateEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private Player player;
	private Userdata userdata;

	/* Constructor ----------------------------------------------------------*/

	public UserdataCreateEvent(Player player, Userdata userdata) {
		this.player = player;
		this.userdata = userdata;
	}

	/* Getter ---------------------------------------------------------------*/

	public Player getPlayer() { return player; }

	public Userdata getUserdata() { return userdata; }

	public static HandlerList getHandlerList() { return handlers; }

	public HandlerList getHandlers() { return handlers; }
}
