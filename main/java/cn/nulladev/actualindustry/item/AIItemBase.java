package cn.nulladev.actualindustry.item;

import cn.nulladev.actualindustry.core.ModItems;
import cn.nulladev.actualindustry.core.ActualIndustry;
import net.minecraft.item.Item;

public abstract class AIItemBase extends Item {
	
	public AIItemBase(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(ActualIndustry.CreativeTab);
		ModItems.ITEMS.add(this);
	}

}
