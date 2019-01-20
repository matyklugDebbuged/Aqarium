package matyk.aqarium.init;

import java.util.ArrayList;
import java.util.List;

import matyk.aqarium.blocks.Dia_block;
import matyk.aqarium.blocks.Ruby_block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RUBY_BLOCK = new Ruby_block("ruby_block", Material.ANVIL, CreativeTabs.DECORATIONS);

	public static final Block DIA_BLOCK = new Dia_block("dia_block", Material.ANVIL, CreativeTabs.DECORATIONS);
}
