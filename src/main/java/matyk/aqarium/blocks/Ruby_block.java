package matyk.aqarium.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import matyk.aqarium.Main;
import matyk.aqarium.init.ModBlocks;
import matyk.aqarium.init.ModItems;
import matyk.aqarium.tiles.TileGen;
import matyk.aqarium.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Ruby_block extends BlockContainer implements IHasModel {

	public Ruby_block(String name, Material material, CreativeTabs tab) 
	{
	super(material);
	setUnlocalizedName(name);
	setRegistryName(name.toLowerCase());
	setCreativeTab(tab);
	setHardness(10000000000f);
	setHarvestLevel("pickaxe", 500);
	setBlockUnbreakable();
	ModBlocks.BLOCKS.add(this);
	ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	
	@Override
    public boolean hasTileEntity(IBlockState state) {
        return super.hasTileEntity(state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileGen();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.AIR;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }
	

}
