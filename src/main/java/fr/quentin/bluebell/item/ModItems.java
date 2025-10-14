package fr.quentin.bluebell.item;

import fr.quentin.bluebell.Bluebell;
import fr.quentin.bluebell.item.custom.HammerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item WOODEN_HAMMER = register(
            "wooden_hammer",
            settings -> new HammerItem(ToolMaterial.WOOD, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item STONE_HAMMER = register(
            "stone_hammer",
            settings -> new HammerItem(ToolMaterial.STONE, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item COPPER_HAMMER = register(
            "copper_hammer",
            settings -> new HammerItem(ToolMaterial.COPPER, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item IRON_HAMMER = register(
            "iron_hammer",
            settings -> new HammerItem(ToolMaterial.IRON, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item GOLDEN_HAMMER = register(
            "golden_hammer",
            settings -> new HammerItem(ToolMaterial.GOLD, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item DIAMOND_HAMMER = register(
            "diamond_hammer",
            settings -> new HammerItem(ToolMaterial.DIAMOND, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item NETHERITE_HAMMER = register(
            "netherite_hammer",
            settings -> new HammerItem(ToolMaterial.NETHERITE, 1.0F, -3.2F, settings),
            new Item.Settings()
    );

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bluebell.MOD_ID, id));
    }

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = keyOf(id);
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void initialize() {}
}