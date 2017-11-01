package cn.nulladev.actualindustry.api.item;

import java.util.List;

import javax.annotation.Nullable;

import cn.nulladev.actualindustry.api.StackUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Items which have quality parameter.
 * A stack with quality will be ignored by StackUtils unless its item instanceof AIQualityItem.
 * @author Chitose
 */
public class AIQualityItem extends AIItemBase {
	
	private final double MAX_QUALITY;	//usually 1.0D

	public AIQualityItem(String name, double maxQuality) {
		super(name);
		this.MAX_QUALITY = maxQuality;
		this.setMaxStackSize(1);
	}
	
	public AIQualityItem(String name) {
		this(name, 1.0D);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        ItemStack stack1 = StackUtils.createStackWithQuality(this, 0);
        ItemStack stack2 = StackUtils.createStackWithQuality(this, MAX_QUALITY);
        items.add(stack1);
        items.add(stack2);
    }
    
    public double getMaxQuality() {
    	return MAX_QUALITY;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
    	double quality = StackUtils.getQuality(stack) * 100;
    	list.add(String.format("quality: %.1f%%", quality));
    }

}
