package matyk.aqarium.util;

import matyk.aqarium.items.Ringos;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    //@GameRegistry.ObjectHolder("aquariumtestmod:ringos")
    public static Ringos ringos = new Ringos();
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ringos.initModel();
}
    
}

