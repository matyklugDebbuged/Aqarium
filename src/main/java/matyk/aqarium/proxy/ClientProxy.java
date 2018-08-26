package matyk.aqarium.proxy;

import matyk.aqarium.util.ModBlocks;
import matyk.aqarium.util.ModItems;
import matyk.aqarium.util.Ref;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy{
	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //ModBlocks.initModels();
        ModItems.initModels();
    }

}
