package cn.nulladev.actualindustry.task;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ListHandler {
	
	@SubscribeEvent
	public void handleTick(TickEvent.ClientTickEvent event) {
		for (int i = 0; i < MIDITaskList.INSTANCE.tasks.size(); i++) {
			Task t = MIDITaskList.INSTANCE.tasks.get(i);
			if (t == null) {
				continue;
			}
			if (t.rest_ticks <= 0) {
				t.execute();
				MIDITaskList.INSTANCE.tasks.remove(t);
			} else {
				t.rest_ticks--;
			}
		}
	}

}
