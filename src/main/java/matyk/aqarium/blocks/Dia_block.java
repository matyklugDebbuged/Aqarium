package matyk.aqarium.blocks;


import matyk.aqarium.Main;
import matyk.aqarium.init.ModBlocks;
import matyk.aqarium.init.ModItems;
import matyk.aqarium.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class Dia_block extends blockBase implements IHasModel {

	
	public Dia_block(String name, Material material, CreativeTabs tab) {
		super(name, material, tab);
	}

	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

	
	
	
}
