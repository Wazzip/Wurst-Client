/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.gui.options;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import tk.wurst_client.Client;
import tk.wurst_client.gui.GuiWurstSlot;
import tk.wurst_client.mod.Mod;

public class GuiKeybindList extends GuiWurstSlot
{
	public GuiKeybindList(Minecraft par1Minecraft, GuiScreen prevMenu)
	{
		super(par1Minecraft, prevMenu.width, prevMenu.height, 36,
			prevMenu.height - 56, 30);
		mc = par1Minecraft;
	}
	
	private int selectedSlot;
	private Minecraft mc;
	@Deprecated
	public static ArrayList<Mod> mods = new ArrayList<Mod>();
	
	@Override
	protected boolean isSelected(int id)
	{
		return selectedSlot == id;
	}
	
	protected int getSelectedSlot()
	{
		return selectedSlot;
	}
	
	@Override
	protected int getSize()
	{
		return Client.wurst.keybinds.size();
	}
	
	@Override
	protected void elementClicked(int var1, boolean var2, int var3, int var4)
	{
		selectedSlot = var1;
	}
	
	@Override
	protected void drawBackground()
	{}
	
	@Override
	protected void drawSlot(int id, int x, int y, int var4, int var5, int var6)
	{
		Entry entry =
			Client.wurst.keybinds.entrySet().toArray(
				new Map.Entry[Client.wurst.keybinds.size()])[id];
		mc.fontRendererObj.drawString("Key: " + entry.getKey(), x + 3, y + 3,
			10526880);
		mc.fontRendererObj.drawString("Command: " + entry.getValue(), x + 3,
			y + 15, 10526880);
	}
}
