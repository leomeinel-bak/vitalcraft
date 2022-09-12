/*
 * File: VitalCraft.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalcraft;

import dev.meinel.leo.vitalcraft.commands.VitalCraftCmd;
import dev.meinel.leo.vitalcraft.files.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class VitalCraft
		extends JavaPlugin {

	private Messages messages;

	@Override
	public void onEnable() {
		Objects.requireNonNull(getCommand("craft"))
				.setExecutor(new VitalCraftCmd());
		messages = new Messages();
		Bukkit.getLogger()
				.info("VitalCraft v" + this.getDescription()
						.getVersion() + " enabled");
		Bukkit.getLogger()
				.info("Copyright (C) 2022 Leopold Meinel");
		Bukkit.getLogger()
				.info("This program comes with ABSOLUTELY NO WARRANTY!");
		Bukkit.getLogger()
				.info("This is free software, and you are welcome to redistribute it under certain conditions.");
		Bukkit.getLogger()
				.info("See https://github.com/LeoMeinel/VitalCraft/blob/main/LICENSE for more details.");
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger()
				.info("VitalCraft v" + this.getDescription()
						.getVersion() + " disabled");
	}

	public Messages getMessages() {
		return messages;
	}
}
