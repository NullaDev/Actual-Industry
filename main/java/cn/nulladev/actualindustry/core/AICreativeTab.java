package cn.nulladev.actualindustry.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author Chitose
 */
public class AICreativeTab extends CreativeTabs {

	public AICreativeTab() {
		super("actual_industry");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.APPLE);
	}

}
