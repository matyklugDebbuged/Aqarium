package matyk.aqarium;

import java.util.logging.Level;

import matyk.aqarium.blocks.BlockGenerator;
import matyk.aqarium.items.Ringos;
import matyk.aqarium.proxy.CommonProxy;
import matyk.aqarium.tile.TileGenerator;
import matyk.aqarium.util.ModBlocks;
import matyk.aqarium.util.Ref;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = matyk.aqarium.util.Ref.modid, name = matyk.aqarium.util.Ref.modname, version = matyk.aqarium.util.Ref.version)
public class Main {

@Instance
public static Main instance;

@SidedProxy(clientSide = Ref.clientProxy, serverSide = Ref.serverProxy)
public static CommonProxy proxy;

@EventHandler
public static void PreInit(FMLPreInitializationEvent event){
	SoundEvent.REGISTRY.getKeys().forEach(System.out::println);
}

@EventHandler
public static void Init(FMLInitializationEvent event){
	SoundEvent.REGISTRY.getKeys().forEach(System.out::println);
}

@EventHandler
public static void PostInit(FMLPostInitializationEvent event){
	SoundEvent.REGISTRY.getKeys().forEach(System.out::println);
}

@Mod.EventBusSubscriber
public static class RegistrationHandler {

    @SubscribeEvent
    public static void registerModels(RegistryEvent.Register<Item> event) {
    }
    
    @SubscribeEvent
    public static void registerItems(ModelRegistryEvent event) {
    }

    @SubscribeEvent
         public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().register(ModBlocks.blockgenerator);
            GameRegistry.registerTileEntity(TileGenerator.class, Ref.modid + "_blockgenerator");
       }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockgenerator).setRegistryName("blockgenerator"));
        event.getRegistry().register(new Ringos());
    }
  boolean played = false;
  float pitch = 1;
  String name = null;
  
  @SubscribeEvent
  public void onGuiOpen(GuiOpenEvent event)
  {
	if(event.getGui() instanceof GuiMainMenu && !played)
      {
          played = true;
          int playOn = 0;
		if(playOn == 1 || playOn == 3)
          {
			SoundEvent sound = SoundEvent.REGISTRY.getObject(new ResourceLocation(name));
              if(sound != null)
              {
				Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(sound, (float)pitch));
              }
              else
              {
              }
          }
      }
  }
}

}







