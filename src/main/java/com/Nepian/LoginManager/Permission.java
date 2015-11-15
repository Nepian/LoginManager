package com.Nepian.LoginManager;

import org.bukkit.command.CommandSender;

public enum Permission {

	COMMAND_LM_RELOAD("LoginManager.command.lm.reload");

	private String permission;

	/* Constructor ----------------------------------------------------------*/

	private Permission(String permission) {
		this.permission = permission;
	}

	/* Methods --------------------------------------------------------------*/

	public static boolean has(CommandSender sender, Permission permission) {
		return has(sender, permission.permission);
	}

	public String toString() {
		return permission;
	}

	/* Private Methods ------------------------------------------------------*/

	private static boolean has(CommandSender sender, String node) {
		return sender.hasPermission(node) || sender.hasPermission(node.toLowerCase());
	}
}
