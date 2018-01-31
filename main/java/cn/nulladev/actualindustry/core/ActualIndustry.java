package cn.nulladev.actualindustry.core;

import cn.nulladev.actualindustry.task.ListHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Chitose
 */
@Mod(modid = ActualIndustry.MODID, name = ActualIndustry.MODNAME, version = ActualIndustry.VERSION )
public class ActualIndustry {

	public static final String MODID = "actualindustry";
	public static final String MODNAME = "Actual Industry";
    public static final String VERSION = "10.17.10.30";
    
    @SidedProxy(clientSide = "cn.nulladev.actualindustry.client.AIClientProxy",
            	serverSide = "cn.nulladev.actualindustry.core.AICommonProxy")
    public static AICommonProxy proxy;
    
    public static final CreativeTabs CreativeTab = new AICreativeTab();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    	AIRegistry.init();
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	proxy.init(event);
		MinecraftForge.EVENT_BUS.register(new ListHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }

	
}
