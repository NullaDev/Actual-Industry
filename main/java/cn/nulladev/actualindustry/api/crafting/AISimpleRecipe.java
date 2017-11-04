package cn.nulladev.actualindustry.api.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	
	private double expIncreaceRate = 0;
	private int level = 0; //0 for basic workshop, 1 for advanced, and 2 for modern
	
	public AISimpleRecipe(int level, Function f, ItemStack... stack) {
		for(ItemStack i : stack) {
			raw.add(i);
		}
		this.product = f;
		this.level = level;
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
	
	public AISimpleRecipe setLevel(int i) {
		this.level = i;
		return this;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public AISimpleRecipe setExpIncreaseRate(double d) {
		this.expIncreaceRate = d;
		return this;
	}
	
	public double getExpIncrease() {
		return new Random().nextDouble() * this.expIncreaceRate;
	}

}
