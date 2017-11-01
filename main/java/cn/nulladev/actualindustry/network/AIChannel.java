package cn.nulladev.actualindustry.network;

import cn.nulladev.actualindustry.api.crafting.AISimpleRecipe;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * This is not Kizuna AI's Channel at all. It's MINE.
 * @author Chitose
 */
public class AIChannel {
	
	public static final String CHANNEL_NAME = "AI_CHANNEL";
	public FMLEventChannel Channel;
	
	public static final AIChannel INSTANCE = new AIChannel();
	
	private static final int CODE_SIMPLE_RECIPE = 0;
	
	private AIChannel(){}
	
	public void init() {
		Channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNEL_NAME);
		Channel.register(this);
	}
	
	public static FMLProxyPacket createSimpleRecipePacket(AISimpleRecipe recipe) {
		PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
		FMLProxyPacket packet = null;
		try {
			buffer.writeInt(CODE_SIMPLE_RECIPE);
			buffer.writeInt(recipe.getID());
			packet = new FMLProxyPacket(buffer, CHANNEL_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return packet;
	}
	
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		EntityPlayerMP player = ((NetHandlerPlayServer)event.getHandler()).player;
		
		PacketBuffer buffer = new PacketBuffer(event.getPacket().payload());
		try {
			switch (buffer.readInt()) {
			case CODE_SIMPLE_RECIPE:
				//do something
				break;
			default:
				//do nothing
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		PacketBuffer buffer = new PacketBuffer(event.getPacket().payload());
		try {
			switch (buffer.readInt()){
			default:
				//do nothing
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
