package com.matyk.aqarium.blocks;

import com.matyk.aqarium.tile.TileGenerator;
import com.matyk.aqarium.util.Ref;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockGenerator extends BlockContainer {

    public BlockGenerator() {
        super(Material.IRON);
        this.setSoundType(SoundType.METAL);
        this.setLightLevel(1f);
        this.setRegistryName("blockgenerator");
        this.setUnlocalizedName(Ref.modid + ".BlockGenerator");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
    
	//@Override
	//public BlockGenerator setCreativeTab(CreativeTabs tab) {
		//super.setCreativeTab(tab);
		//return this;
	//}

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return super.hasTileEntity(state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileGenerator();
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
