package com.matyk.aqarium;

import com.matyk.aqarium.proxy.CommonProxy;
import com.matyk.aqarium.util.Ref;

import net.minecraft.item.Item;
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
	public static void registerItems(RegistryEvent.Register<Item> event) {
	}
	
	@SubscribeEvent
	public static void registerItems(ModelRegistryEvent event) {
	}

}



}



