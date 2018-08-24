package com.matyk.aqarium.util;

import com.matyk.aqarium.blocks.BlockGenerator;
import com.matyk.aqarium.tile.TileGenerator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class ModBlocks {

    @GameRegistry.ObjectHolder("aqariumtestmod:BlockGenerator")
    public static BlockGenerator BlockGenerator;

    
}