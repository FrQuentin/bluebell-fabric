package fr.quentin.bluebell.tag;

import fr.quentin.bluebell.Bluebell;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> HAMMERS = of("hammers");
    public static final TagKey<Item> EMERALD_TOOL_MATERIALS = of("emerald_tool_materials");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Bluebell.MOD_ID, id));
    }
}