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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy{
	
	public static BlockGenerator blockGenerator;  // this holds the unique instance of your block
	public static ItemBlock itemBlockGenerator;  // this holds the unique instance of the ItemBlock corresponding to your block
    /*@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockGenerator());
        GameRegistry.registerTileEntity(TileGenerator.class, Ref.modid + "_blockgenerator");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockgenerator).setRegistryName("blockgenerator"));
        event.getRegistry().register(new Ringos());

   }*/ 
    public static void preInitServer()
    {
      // each instance of your block should have two names:
      // 1) a registry name that is used to uniquely identify this block.  Should be unique within your mod.  use lower case.
      // 2) an 'unlocalised name' that is used to retrieve the text name of your block in the player's language.  For example-
      //    the unlocalised name might be "water", which is printed on the user's screen as "Wasser" in German or
      //    "aqua" in Italian.
      //
      //    Multiple blocks can have the same unlocalised name - for example
      //  +----RegistryName----+---UnlocalisedName----+
      //  |  flowing_water     +       water          |
      //  |  stationary_water  +       water          |
      //  +--------------------+----------------------+
      //
      blockGenerator = (BlockGenerator)(new BlockGenerator().setUnlocalizedName("blockGenerator"));
      blockGenerator.setRegistryName("blockgenerator");
      ForgeRegistries.BLOCKS.register(blockGenerator);

      //We also need to create and register an ItemBlock for this block otherwise it won't appear in the inventory
      itemBlockGenerator = new ItemBlock(blockGenerator);
      itemBlockGenerator.setRegistryName(blockGenerator.getRegistryName());
      ForgeRegistries.ITEMS.register(itemBlockGenerator);
    }

    
}
