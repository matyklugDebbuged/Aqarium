package matyk.aqarium.init;

import java.util.ArrayList;
import java.util.List;

import matyk.aqarium.items.DiaRing;
import matyk.aqarium.items.RubyRing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final Item RUBYRING = new RubyRing("ruby", CreativeTabs.MISC);
	public static final Item DIARING = new DiaRing("dia", CreativeTabs.MISC);
	
	
}
