package cn.nulladev.actualindustry.api.block;

import cn.nulladev.actualindustry.core.ActualIndustry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author Chitose
 */
public abstract class AIBlockBase extends Block {

	public AIBlockBase(String name, Material material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(ActualIndustry.CreativeTab);
	}
	
	public AIBlockBase(String name, Material material, float hardness, float resistance) {
		this(name, material);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

}
