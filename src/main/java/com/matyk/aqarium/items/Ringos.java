package com.matyk.aqarium.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class Ringos extends Item implements IBauble {

	@Override
	public Ringos setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
    public Ringos() {
        setRegistryName("ringos");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(com.matyk.aqarium.util.Ref.modid + ".firstitem");     // Used for localization (en_US.lang)
    }

    @Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}
    
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.getItemDamage()==0 && player.ticksExisted%39==0) {
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING,40,0,true,true));
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
}
