package cn.nulladev.actualindustry.item;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import cn.nulladev.actualindustry.api.item.AIItemBase;
import cn.nulladev.actualindustry.midi.MidiParser;
import cn.nulladev.actualindustry.midi.Note;
import cn.nulladev.actualindustry.task.MIDITaskList;
import cn.nulladev.actualindustry.task.Task;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemDebug extends AIItemBase {
	
	public ItemDebug() {
		super("item_debug");
		this.setMaxStackSize(1);		
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		MIDITaskList list = MIDITaskList.INSTANCE;
		list.clear();
		try {
			MidiParser parser = new MidiParser(new File("D:\\test.mid"));
			for(Note n : parser.translateMidiToNotes()) {
				int start_tick = n.getStartingBeat() / 24;
				
				int pitch;
				SoundEvent ins;
				if (n.getPitch() >= 72) {
					pitch = n.getPitch() - 72;
					ins = SoundEvents.BLOCK_NOTE_BELL;
				} else {
					pitch = n.getPitch() - 48;
					ins = SoundEvents.BLOCK_NOTE_HARP;
				}
				float pitch1 = (float)Math.pow(2, (pitch - 12) / 12D); 
				Task t = new Task(start_tick, () -> {
					world.playSound(null, new BlockPos(player.posX, player.posY, player.posZ), ins, SoundCategory.RECORDS, 3.0F * n.getVolume() / 100, pitch1);
			        world.spawnParticle(EnumParticleTypes.NOTE, player.posX, player.posY + 2, player.posZ, (pitch % 24) / 24.0D, 0.0D, 0.0D);
				});
				list.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

}
