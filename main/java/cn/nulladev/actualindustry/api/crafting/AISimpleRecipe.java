package cn.nulladev.actualindustry.api.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

import cn.nulladev.actualindustry.core.AIRecipes;
import net.minecraft.item.ItemStack;

/**
 * Far more complex than it seems to be.
 * @author Chitose
 */
public class AISimpleRecipe {
	
	public final List<ItemStack> raw = new ArrayList<ItemStack>();
	public final Function<Double, ItemStack> product;	//The double parameter -> exp value of this recipe
	private final int id;	//Automatically create.
	
	public AISimpleRecipe(Function f, ItemStack... stack) {
		for(ItemStack i : stack) {
			raw.add(i);
		}
		this.product = f;
		this.id = AIRecipes.SIMPLE_RECIPES.size();
		AIRecipes.SIMPLE_RECIPES.add(this);
	}
	
	public ItemStack getProduct(double exp) {
		return product.apply(exp);
	}
	
	public int getID() {
		return this.id;
	}
	
	@Nullable
	public static AISimpleRecipe getRecipeFromID(int id) {
		for (AISimpleRecipe r : AIRecipes.SIMPLE_RECIPES) {
			if (r.getID() == id)
				return r;
		}
		return null;
	}

}
