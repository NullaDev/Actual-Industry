package cn.nulladev.actualindustry.block;

import cn.nulladev.actualindustry.api.block.AIBlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Chitose
 */
public class BlockBasicWorshop extends AIBlockBase {

	public BlockBasicWorshop() {
		super("basic_workshop", Material.WOOD, 0, 0);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			return false;
		}
		//Minecraft.getMinecraft().displayGuiScreen(xxx);
		return true;
    }

}
