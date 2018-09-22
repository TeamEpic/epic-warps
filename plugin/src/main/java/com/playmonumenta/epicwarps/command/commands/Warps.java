package com.playmonumenta.epicwarps.command.commands;

import com.playmonumenta.epicwarps.command.AbstractPlayerCommand;
import com.playmonumenta.epicwarps.command.CommandContext;
import com.playmonumenta.epicwarps.WarpManager;

import net.sourceforge.argparse4j.inf.ArgumentParser;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Warps extends AbstractPlayerCommand {

	public Warps(Plugin plugin) {
		super(
		    "warps",
		    "Lists available warps.",
		    plugin
		);
	}

	@Override
	protected void configure(final ArgumentParser parser) {
		parser.addArgument("page")
		.help("Warp page")
		.type(Integer.class)
		.nargs("?")
		.setDefault(1);
	}

	@Override
	protected boolean run(final CommandContext context) {
		final Player player = context.getPlayer().get();
		final int page = context.getNamespace().get("page");

		try {
			WarpManager.getWarpManager().listWarps(player, page);
		} catch (Exception e) {
			player.sendMessage(ChatColor.RED + "" + e.getMessage());
		}

		return true;
	}
}
