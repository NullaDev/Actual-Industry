package cn.nulladev.actualindustry;

import cn.nulladev.actualindustry.blocks.AIBlockRegister;
import net.fabricmc.api.ModInitializer;

public class ActualIndustry implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		AIBlockRegister.RegisterAIBlock();
		AIBlockRegister.RegisterAIBlockItem();
	}
}
