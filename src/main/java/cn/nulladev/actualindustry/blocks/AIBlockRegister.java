package cn.nulladev.actualindustry.blocks;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AIBlockRegister {
    public static final AIOreBlock COPPER_ORE = new AIOreBlock();
    public static final AIOreBlock TIN_ORE = new AIOreBlock();
    public static final AIOreBlock ZINC_ORE = new AIOreBlock();

    public static final BlockItem COPPER_ORE_ITEM = new BlockItem(COPPER_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem TIN_ORE_ITEM = new BlockItem(TIN_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem ZINC_ORE_ITEM = new BlockItem(ZINC_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void RegisterAIBlock() {
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "tin_ore"), TIN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("actualindustry", "zinc_ore"), ZINC_ORE);
    }

    public static void RegisterAIBlockItem() {
        Registry.register(Registry.ITEM, new Identifier("actualindustry", "copper_ore_item"), COPPER_ORE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("actualindustry", "tin_ore_item"), TIN_ORE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("actualindustry", "zinc_ore_item"), ZINC_ORE_ITEM);
    }
}
