package cn.nulladev.actualindustry.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class AIOreBlock extends Block {
    public AIOreBlock() {
        super(FabricBlockSettings.of(Material.STONE).strength(3.0f, 3.0f).requiresTool());
    }
}
