package cn.nulladev.actualindustry.api;

import cn.nulladev.actualindustry.api.item.AIQualityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Chitose
 */
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
		quality = Math.min(quality, AIQualityItem.MAX_QUALITY);
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
	
	public static ItemStack setQuality(ItemStack stack, double quality) {
		quality = Math.max(quality, 0);
		if (stack.getItem() instanceof AIQualityItem) {
			getNBT(stack).setDouble(TAG_NAME, quality);
		}
		return stack;
	}

}