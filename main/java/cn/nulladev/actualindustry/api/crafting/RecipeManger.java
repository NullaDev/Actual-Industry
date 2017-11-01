package cn.nulladev.actualindustry.api.crafting;

import cn.nulladev.actualindustry.core.AIRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Really Notch BULLSHIT Tag.
 * Warning: UNTESTED
 * @author Chitose
 */
public class RecipeManger {
	
	public static final double MAX_EXP = 1.0D;
	public static final String EXP_INFO = "AI_EXP_INFO";
	
	public static final RecipeManger INSTANCE = new RecipeManger();
	
	private RecipeManger() {}
	
	@SideOnly(Side.SERVER)
	public void init(EntityPlayer crafter) {
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < AIRecipes.SIMPLE_RECIPES.size(); i++) {
			list.set(i, new NBTTagDouble(0D));
		}
		crafter.getEntityData().setTag(EXP_INFO, list);
	}
	
	@SideOnly(Side.SERVER)
	public double getExp(EntityPlayer crafter, AISimpleRecipe recipe) {
		if (!crafter.getEntityData().hasKey(EXP_INFO)) {
			init(crafter);
			return 0D;
		}
		NBTTagList list = (NBTTagList) crafter.getEntityData().getTag(EXP_INFO);
		return list.getDoubleAt(recipe.getID());
	}
	
	@SideOnly(Side.SERVER)
	public void setExp(EntityPlayer crafter, AISimpleRecipe recipe, double exp) {
		exp = Math.min(exp, MAX_EXP);
		if (!crafter.getEntityData().hasKey(EXP_INFO)) {
			init(crafter);
		}
		NBTTagList list = (NBTTagList) crafter.getEntityData().getTag(EXP_INFO);
		list.set(recipe.getID(), new NBTTagDouble(exp));
	}
	
	@SideOnly(Side.SERVER)
	public void addExp(EntityPlayer crafter, AISimpleRecipe recipe, double exp) {
		exp = Math.min(exp + getExp(crafter, recipe), MAX_EXP);
		setExp(crafter, recipe, exp);
	}

}
