package cn.nulladev.actualindustry.api;

import cn.nulladev.actualindustry.api.item.AIQualityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class StackUtils {
	
	public static final String TAG_NAME = "quality";
	
	public static NBTTagCompound getNBT(ItemStack stack) {
		if (stack.getTagCompound() != null) {
			return stack.getTagCompound();
		} else {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			return nbt;
		}
	}
		
	public static ItemStack createStackWithQuality(AIQualityItem item, double quality) {
		quality = Math.max(quality, 0);
		quality = Math.min(quality, item.getMaxQuality());
		ItemStack stack = new ItemStack(item);
		setQuality(stack, quality);
		return stack;
	}
	
	public static double getQuality(ItemStack stack) {
		if (stack.getItem() instanceof AIQualityItem) {
			if (!getNBT(stack).hasKey(TAG_NAME)) {
				setQuality(stack, 0D);
			}
			return getNBT(stack).getDouble(TAG_NAME);
		} else {
			return 0D;
		}
	}
	
	public static void setQuality(ItemStack stack, double quality) {
		if (stack.getItem() instanceof AIQualityItem) {
			getNBT(stack).setDouble(TAG_NAME, quality);
		}
	}


}