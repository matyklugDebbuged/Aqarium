package matyk.aqarium;

import baubles.common.CommonProxy;
import matyk.aqarium.event.OnDeath;
import matyk.aqarium.proxy.ServerProxy;
import matyk.aqarium.util.Ref;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import matyk.aqarium.util.Ref;

@Mod(modid=Ref.MOD_ID, name = Ref.NAME, version = Ref.VERSION)
public class Main {

	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide=Ref.CLIENT_PROXY_CLASS, serverSide=Ref.SERVER_PROXY_CLASS)
	public static ServerProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
	MinecraftForge.EVENT_BUS.register(new OnDeath());
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
		
	}
	
	

}

