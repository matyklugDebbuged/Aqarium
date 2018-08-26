package matyk.aqarium.proxy;

import matyk.aqarium.blocks.BlockGenerator;
import matyk.aqarium.items.Ringos;
import matyk.aqarium.tile.TileGenerator;
import matyk.aqarium.util.ModBlocks;
import matyk.aqarium.util.Ref;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockGenerator());
        GameRegistry.registerTileEntity(TileGenerator.class, Ref.modid + "_blockgenerator");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockgenerator).setRegistryName("blockgenerator"));
        event.getRegistry().register(new Ringos());

    }

    
}
