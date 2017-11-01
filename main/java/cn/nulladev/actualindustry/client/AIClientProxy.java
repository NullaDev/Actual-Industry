package cn.nulladev.actualindustry.client;

import cn.nulladev.actualindustry.core.AICommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AIClientProxy extends AICommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		//Display.setTitle("Minceraft 1.7.10");
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
