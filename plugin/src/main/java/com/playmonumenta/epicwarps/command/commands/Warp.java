package com.playmonumenta.epicwarps.command.commands;

import com.playmonumenta.epicwarps.command.AbstractPlayerCommand;
import com.playmonumenta.epicwarps.command.CommandContext;
import com.playmonumenta.epicwarps.WarpManager;

import net.sourceforge.argparse4j.inf.ArgumentParser;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Warp extends AbstractPlayerCommand {

	public Warp(Plugin plugin) {
		super(
		    "warp",
		    "Teleports the player to the specified warp.",
		    plugin
		);
	}

	@Override
	protected void configure(final ArgumentParser parser) {
		parser.addArgument("name")
		.help("Warp destination")
		.type(String.class);
	}

	@Override
	protected boolean run(final CommandContext context) throws Exception {
		final Player player = context.getPlayer().get();
		final String name = context.getNamespace().get("name");

		WarpManager.getWarpManager().warp(player, name);

		return true;
	}
}
