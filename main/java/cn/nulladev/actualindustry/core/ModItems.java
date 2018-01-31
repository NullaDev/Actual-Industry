package cn.nulladev.actualindustry.core;

import java.util.ArrayList;
import java.util.List;

import cn.nulladev.actualindustry.api.item.AIQualityItem;
import cn.nulladev.actualindustry.api.item.AISimpleItem;
import cn.nulladev.actualindustry.item.ItemDebug;
import net.minecraft.item.Item;

/**
 * @author Chitose
 */
public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item itemtest;
	public static Item itemtest2;
	public static Item itemdebug;
	
	public static void init() {
		itemtest = new AISimpleItem("test");
		itemtest2 = new AIQualityItem("test2");
		itemdebug = new ItemDebug();
	}

}
