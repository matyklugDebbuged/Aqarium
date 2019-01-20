package matyk.aqarium.items;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Multimap;

import baubles.api.BaubleType;

import baubles.api.IBauble;
import lilliputian.capabilities.ISizeCapability;
import lilliputian.capabilities.SizeProvider;
import matyk.aqarium.Main;
import matyk.aqarium.init.ModItems;
import matyk.aqarium.text.TextUtils;
import matyk.aqarium.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import toughasnails.api.TANCapabilities;
import toughasnails.api.stat.capability.ITemperature;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.temperature.IModifierMonitor;
import toughasnails.api.temperature.ITemperatureModifier;
import toughasnails.api.temperature.Temperature;
import toughasnails.api.thirst.IDrink;
import toughasnails.temperature.modifier.TemperatureModifier;
import net.minecraft.entity.Entity;
import java.util.List;

public class DiaRing extends Item implements IHasModel, IBauble{
	public DiaRing(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
	}

	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
       
            tooltip.add("Fly");
            tooltip.add("Step Assist");
            tooltip.add("Speed");
            tooltip.add("Revive");
            tooltip.add("Auto UnThirster");
            tooltip.add("Temp Regulator");
        
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
			return BaubleType.RING;
	}
	
	public void onEquipped(ItemStack itemstack,EntityLivingBase living) {
		startFlying((EntityPlayer) living);
		((EntityPlayer) living).getEntityData().setBoolean("revive", true);
		EntityPlayer player = ((EntityPlayer) living);
		IThirst thirst = player.getCapability(TANCapabilities.THIRST, null);
		System.out.println(thirst.getHydration()+thirst.getThirst()+"futing");
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase living) {
		if (living instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer) living);
            if (!player.capabilities.allowFlying) {
                startFlying(player);
            }
    		player.stepHeight = 2.0f;
        }
	EntityPlayer player = ((EntityPlayer) living);
	IThirst thirst = player.getCapability(TANCapabilities.THIRST, null);
	thirst.setHydration(20.0f-thirst.getHydration());
	ITemperature temp = player.getCapability(TANCapabilities.TEMPERATURE, null);
	int tem = 10;
	Temperature tempe = new Temperature(tem);
	temp.setTemperature(tempe);
	}
	
	float stepHeight;
	@SubscribeEvent
	public void onUnequipped(ItemStack itemstack,EntityLivingBase living) {
		stopFlying((EntityPlayer) living);
		((EntityPlayer) living).getEntityData().removeTag("revive");
		
	}
	
	private void startFlying(EntityPlayer player) {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
            player.capabilities.setFlySpeed(1.0f);
            player.capabilities.setPlayerWalkSpeed(1.0f);
            
        }
    }
	
	private void stopFlying(EntityPlayer player) {
        player.capabilities.isFlying = false;
        player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
            player.capabilities.setFlySpeed(0.1f);
            player.capabilities.setPlayerWalkSpeed(0.1f);
            
            
        }
        	player.stepHeight = 0.5f;
	
	}
	
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
		EntityPlayer player = event.player;
		player.stepHeight = stepHeight;
		
    }

	
	
   }

