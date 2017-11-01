package cn.nulladev.actualindustry.core;

import java.util.ArrayList;
import java.util.List;

import cn.nulladev.actualindustry.item.AISimpleItem;
import net.minecraft.item.Item;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item itemtest;
	
	public static void init() {
		itemtest = new AISimpleItem("test");
	}

}
