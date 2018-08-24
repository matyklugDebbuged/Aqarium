package com.matyk.aqarium;

import com.matyk.aqarium.blocks.BlockGenerator;
import com.matyk.aqarium.items.Ringos;
import com.matyk.aqarium.proxy.CommonProxy;
import com.matyk.aqarium.tile.TileGenerator;
import com.matyk.aqarium.util.ModBlocks;
import com.matyk.aqarium.util.Ref;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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

@Mod(modid = com.matyk.aqarium.util.Ref.modid, name = com.matyk.aqarium.util.Ref.modname, version = com.matyk.aqarium.util.Ref.version)
public class Main {

@Instance
public static Main instance;

@SidedProxy(clientSide = Ref.clientProxy, serverSide = Ref.serverProxy)
public static CommonProxy proxy;

@EventHandler
public static void PreInit(FMLPreInitializationEvent event){
	
}

@EventHandler
public static void Init(FMLInitializationEvent event){
	
}

@EventHandler
public static void PostInit(FMLPostInitializationEvent event){
	
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
}

}







