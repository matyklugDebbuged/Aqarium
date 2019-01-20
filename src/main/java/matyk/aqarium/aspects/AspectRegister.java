package matyk.aqarium.aspects;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

public class AspectRegister {

	@SubscribeEvent
	public static void registerAspects(AspectRegistryEvent event) { 
	event.register.registerObjectTag("blockGlass", (new AspectList()).add(Aspect.ORDER, 500)); 
	}
	
	
}
