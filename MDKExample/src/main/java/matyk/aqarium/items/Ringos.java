package matyk.aqarium.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Ringos extends Item implements IBauble {

	@Override
	public Ringos setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
    public Ringos() {
        this.setRegistryName("ringos");        // The unique name (within your mod) that identifies this item
        this.setUnlocalizedName(matyk.aqarium.util.Ref.modid + ".ringos");     // Used for localization (en_US.lang)
       // this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}
    
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.getItemDamage()==0 && player.ticksExisted%39==0) {
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING,40,0,true,true));
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		
		return true;
	}
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
