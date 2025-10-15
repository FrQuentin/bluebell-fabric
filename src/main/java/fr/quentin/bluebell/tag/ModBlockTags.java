package fr.quentin.bluebell.tag;

import fr.quentin.bluebell.Bluebell;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = of("incorrect_for_emerald_tool");
    public static final TagKey<Block> NEEDS_EMERALD_TOOL = of("needs_emerald_tool");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Bluebell.MOD_ID, id));
    }
}
