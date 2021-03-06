/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.mod.mods;

import net.minecraft.client.Minecraft;
import tk.wurst_client.event.EventManager;
import tk.wurst_client.event.listeners.UpdateListener;
import tk.wurst_client.mod.Mod;
import tk.wurst_client.mod.Mod.Category;
import tk.wurst_client.mod.Mod.Info;

@Info(category = Category.MOVEMENT,
	description = "Automatically swims like a dolphin.",
	name = "Dolphin")
public class Dolphin extends Mod implements UpdateListener
{
	@Override
	public void onEnable()
	{
		EventManager.update.addListener(this);
	}
	
	@Override
	public void onUpdate()
	{
		if(Minecraft.getMinecraft().thePlayer.isInWater()
			&& !Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed)
			Minecraft.getMinecraft().thePlayer.motionY += 0.04;
	}
	
	@Override
	public void onDisable()
	{
		EventManager.update.removeListener(this);
	}
}
