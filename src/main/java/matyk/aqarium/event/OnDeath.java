package matyk.aqarium.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.EntityEquipmentSlot.Type;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnDeath {
	
	 public static boolean isInfinite(EntityPlayer player) {
		 	return true;
	 	}

	@SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (player.getEntityData().getBoolean("revive")) {
                event.setCanceled(true);
                player.setHealth(player.getMaxHealth());
            }
        }
    }
}


