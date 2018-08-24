package com.matyk.aqarium.api.baubles.api.cap;

import com.matyk.aqarium.api.baubles.api.BaubleType;
import com.matyk.aqarium.api.baubles.api.IBauble;
import net.minecraft.item.ItemStack;

public class BaubleItem implements IBauble
{
	private BaubleType baubleType;

	public BaubleItem(BaubleType type) {
		baubleType = type;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return baubleType;
	}
}
