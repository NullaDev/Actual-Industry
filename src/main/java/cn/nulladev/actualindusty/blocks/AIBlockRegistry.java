package cn.nulladev.actualindusty.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AIBlockRegistry {
    public static final OreBlock COPPER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
                                                            .requiresTool().
                                                            strength(3.0f, 3.0f));
    public static final OreBlock TIN_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool().
                    strength(3.0f, 3.0f));
    public static final OreBlock ZINC_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool().
                    strength(3.0f, 3.0f));

    public void AIBlockRegister() {
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "tin_ore"), TIN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "zinc_ore"), TIN_ORE);
    }
}
