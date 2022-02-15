/*
 * VitalCraft is a Spigot Plugin that gives players the ability to open a crafting interface.
 * Copyright © 2022 Leopold Meinel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalCraft/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalcraft.commands;

import com.tamrielnetwork.vitalcraft.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VitalCraftCmd implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		// Check args length
		if (args.length != 0) {
			Utils.sendMessage(sender, "invalid-option");
			return true;
		}
		// Toggle Crafting Interface
		toggleCraftingInterface(sender);
		return true;

	}

	private void toggleCraftingInterface(CommandSender sender) {
		// Check if command sender is a player
		if (!(sender instanceof Player)) {
			Utils.sendMessage(sender, "player-only");
			return;
		}
		// Check perms
		if (!sender.hasPermission("vitalcraft.craft")) {
			Utils.sendMessage(sender, "no-perms");
			return;
		}
		((Player) sender).openWorkbench(((Player) sender).getLocation(),true);

	}
}