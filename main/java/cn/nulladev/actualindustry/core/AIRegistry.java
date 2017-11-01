package cn.nulladev.actualindustry.core;

import net.minecraft.item.Item;
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
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		for (Item i : ModItems.ITEMS)
		registry.register(i);
	}

}
