package cn.nulladev.actualindustry.client;

import org.lwjgl.opengl.Display;

import cn.nulladev.actualindustry.core.AICommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Chitose
 */
public class AIClientProxy extends AICommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		Display.setTitle("Minceraft 1.12.2");	//Minceraft :)
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
