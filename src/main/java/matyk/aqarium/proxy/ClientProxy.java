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
	@SubscribeEvent
	public static void preInitClientOnly()
	  {
	    // This step is necessary in order to make your block render properly when it is an item (i.e. in the inventory
	    //   or in your hand or thrown on the ground).
	    // It must be done on client only, and must be done after the block has been created in Common.preinit().
	    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("aqariumtestmod:blockgenerator", "inventory");
	    final int DEFAULT_ITEM_SUBTYPE = 0;
	    ModelLoader.setCustomModelResourceLocation(ServerProxy.itemBlockGenerator, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	  }
	
	

}
