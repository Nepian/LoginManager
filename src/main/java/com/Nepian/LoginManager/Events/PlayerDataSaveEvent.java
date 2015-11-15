package com.Nepian.LoginManager.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Nepian.LoginManager.PlayerData.PlayerData;

public class PlayerDataSaveEvent extends Event {
	private static HandlerList handlers = new HandlerList();

	private Player player;
	private PlayerData data;

	public PlayerDataSaveEvent(Player player, PlayerData data) {
		this.player = player;
		this.data = data;
	}

	public Player getPlayer() {
		return this.player;
	}

	public PlayerData getPlayerData() {
		return this.data;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

}
