package com.matyk.aqarium.proxy;

import com.matyk.aqarium.blocks.BlockGenerator;
import com.matyk.aqarium.items.Ringos;
import com.matyk.aqarium.util.ModBlocks;
import com.matyk.aqarium.util.Ref;
import com.matyk.aqarium.tile.TileGenerator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {

	
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockGenerator());
        GameRegistry.registerTileEntity(TileGenerator.class, Ref.modid + "_blockgenerator");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.BlockGenerator).setRegistryName("blockgenerator"));
        event.getRegistry().register(new Ringos());

    }

    
}

    


