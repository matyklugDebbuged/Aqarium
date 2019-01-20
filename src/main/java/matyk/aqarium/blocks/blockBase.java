package matyk.aqarium.blocks;

import matyk.aqarium.Main;
import matyk.aqarium.init.ModBlocks;
import matyk.aqarium.init.ModItems;
import matyk.aqarium.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class blockBase extends Block implements IHasModel {

	public blockBase(String name, Material material, CreativeTabs tab) 
	{
		super(material);
	setUnlocalizedName(name);
	setRegistryName(name.toLowerCase());
	setCreativeTab(tab);
	
	ModBlocks.BLOCKS.add(this);
	ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	

}
