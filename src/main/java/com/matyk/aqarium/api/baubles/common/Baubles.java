package com.matyk.aqarium.api.baubles.common; 

import java.io.File;

import com.matyk.aqarium.api.baubles.api.BaubleType;
import com.matyk.aqarium.api.baubles.api.IBauble;
import com.matyk.aqarium.api.baubles.api.cap.BaubleItem;
import com.matyk.aqarium.api.baubles.api.cap.BaublesCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import com.matyk.aqarium.api.baubles.api.cap.BaublesCapabilities.CapabilityBaubles;
import com.matyk.aqarium.api.baubles.api.cap.BaublesContainer;
import com.matyk.aqarium.api.baubles.api.cap.IBaublesItemHandler;
import com.matyk.aqarium.api.baubles.common.event.CommandBaubles;
import com.matyk.aqarium.api.baubles.common.network.PacketHandler;

@Mod(
		modid = Baubles.MODID, 
		name = Baubles.MODNAME, 
		version = Baubles.VERSION, 
		guiFactory = "baubles.client.gui.BaublesGuiFactory",
		dependencies = "required-after:forge@[14.21.0.2348,);")
public class Baubles {

	public static final String MODID = "baubles";
	public static final String MODNAME = "Baubles";
	public static final String VERSION = "1.5.2";

	@SidedProxy(clientSide = "com.matyk.aqarium.api.baubles.client.ClientProxy", serverSide = "com.matyk.aqarium.api.baubles.common.CommonProxy")
	public static CommonProxy proxy;

	@Instance(value=Baubles.MODID)
	public static Baubles instance;

	public File modDir;

	public static final Logger log = LogManager.getLogger(MODID.toUpperCase());
	public static final int GUI = 0;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		modDir = event.getModConfigurationDirectory();

		try {
			Config.initialize(event.getSuggestedConfigurationFile());
		} catch (Exception e) {
			Baubles.log.error("BAUBLES has a problem loading it's configuration");
		} finally {
			if (Config.config!=null) Config.save();
		}

		CapabilityManager.INSTANCE.register(IBaublesItemHandler.class,
				new CapabilityBaubles<IBaublesItemHandler>(), BaublesContainer.class);

		CapabilityManager.INSTANCE
				.register(IBauble.class, new BaublesCapabilities.CapabilityItemBaubleStorage(), () -> new BaubleItem(BaubleType.TRINKET));

		proxy.registerEventHandlers();
		PacketHandler.init();

		Config.save();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.init();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandBaubles());
	}
}
