package cn.nulladev.actualindustry.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author Chitose
 */
@EventBusSubscriber
public class AIRegistry {
	
	public static void init() {
		ModItems.init();
		ModBlocks.init();
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		for (Item i : ModItems.ITEMS)
			registry.register(i);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();
		for (Block i : ModBlocks.BLOCKS)
			registry.register(i);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		for (Block i : ModBlocks.BLOCKS)
			registry.register(new ItemBlock(i));
	}

}
