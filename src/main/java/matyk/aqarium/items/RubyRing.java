package matyk.aqarium.items;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import baubles.api.BaubleType;

import baubles.api.IBauble;
import matyk.aqarium.Main;
import matyk.aqarium.init.ModItems;
import matyk.aqarium.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.items.IGoggles;
import thaumcraft.api.items.IRevealer;
import thaumcraft.api.items.IVisDiscountGear;

public class RubyRing extends Item implements IHasModel, IBauble, IGoggles, IRevealer, IVisDiscountGear{
	public RubyRing(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
			return BaubleType.RING;
	}
	
	public void onEquipped(ItemStack itemstack, EntityLivingBase player ) {
		player.setEntityInvulnerable(true);
	}
	
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player ) {
		player.setEntityInvulnerable(false);
	}
	
	public void onWornTick(ItemStack stack, EntityLivingBase living) {
		EntityPlayer player = ((EntityPlayer) living);
		if(player.isBurning())
            player.extinguish();
		player.setAir(300);
		player.getFoodStats().addStats(20, 20F);
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION,400,0,false,false));
         List<PotionEffect> effects = Lists.newArrayList(player.getActivePotionEffects());
         for (PotionEffect potion : Collections2.filter(effects, potion -> potion.getPotion().isBadEffect())) {
             player.removePotionEffect(potion.getPotion());
         }
	}

	@Override
	public boolean showIngamePopups(ItemStack arg0, EntityLivingBase arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	

	@Override
	public int getVisDiscount(ItemStack arg0, EntityPlayer arg1) {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public boolean showNodes(ItemStack arg0, EntityLivingBase arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
       
            tooltip.add("Invureability");
            tooltip.add("AutoExtinguish");
            tooltip.add("Night Vision");
            tooltip.add("NoBadPotions");
            tooltip.add("UnderWater Breathing");
            tooltip.add("NoHunger");
        
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	
	
}

