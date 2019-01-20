package matyk.aqarium.event;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class onRenderFog {

	@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderFog(EntityViewRenderEvent.FogDensity event) {
        if(event.getState().getMaterial() == Material.WATER) {
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            event.setDensity(0f);
            event.setCanceled(true);
        } else if(event.getState().getMaterial() == Material.LAVA) {
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            event.setDensity(0f);
            event.setCanceled(true);
        }
    }
	
	
}
