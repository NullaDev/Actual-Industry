package cn.nulladev.actualindustry.api.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import cn.nulladev.actualindustry.core.AIRecipes;
import net.minecraft.item.ItemStack;

public class AISimpleRecipe {
	
	public final List<ItemStack> raw = new ArrayList<ItemStack>();
	public final Function<Double, ItemStack> product;
	
	public AISimpleRecipe(Function f, ItemStack... stack) {
		for(ItemStack i : stack) {
			raw.add(i);
		}
		this.product = f;
		AIRecipes.SIMPLE_RECIPES.add(this);
	}
	
	public ItemStack getProduct(double exp) {
		return product.apply(exp);
	}

}
