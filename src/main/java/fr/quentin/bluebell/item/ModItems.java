package fr.quentin.bluebell.item;

import fr.quentin.bluebell.Bluebell;
import fr.quentin.bluebell.item.custom.HammerItem;
import fr.quentin.bluebell.item.equipment.ModArmorMaterials;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
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
    public static final Item EMERALD_HAMMER = register(
            "emerald_hammer",
            settings -> new HammerItem(ModToolMaterial.EMERALD, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item NETHERITE_HAMMER = register(
            "netherite_hammer",
            settings -> new HammerItem(ToolMaterial.NETHERITE, 1.0F, -3.2F, settings),
            new Item.Settings()
    );
    public static final Item EMERALD_SWORD = register("emerald_sword", new Item.Settings().sword(ModToolMaterial.EMERALD, 3.0F, -2.4F));
    public static final Item EMERALD_SHOVEL = register("emerald_shovel", settings -> new ShovelItem(ModToolMaterial.EMERALD, 1.5F, -3.0F, settings));
    public static final Item EMERALD_PICKAXE = register("emerald_pickaxe", new Item.Settings().pickaxe(ModToolMaterial.EMERALD, 1.0F, -2.8F));
    public static final Item EMERALD_AXE = register("emerald_axe", settings -> new AxeItem(ModToolMaterial.EMERALD, 5.0F, -3.0F, settings));
    public static final Item EMERALD_HOE = register("emerald_hoe", settings -> new HoeItem(ModToolMaterial.EMERALD, -3.0F, 0.0F, settings));
    public static final Item EMERALD_HELMET = register("emerald_helmet", new Item.Settings().armor(ModArmorMaterials.EMERALD, EquipmentType.HELMET));
    public static final Item EMERALD_CHESTPLATE = register("emerald_chestplate", new Item.Settings().armor(ModArmorMaterials.EMERALD, EquipmentType.CHESTPLATE));
    public static final Item EMERALD_LEGGINGS = register("emerald_leggings", new Item.Settings().armor(ModArmorMaterials.EMERALD, EquipmentType.LEGGINGS));
    public static final Item EMERALD_BOOTS = register("emerald_boots", new Item.Settings().armor(ModArmorMaterials.EMERALD, EquipmentType.BOOTS));
    public static final Item EMERALD_HORSE_ARMOR = register("emerald_horse_armor", new Item.Settings().horseArmor(ModArmorMaterials.EMERALD));
    public static final Item EMERALD_BOW = register("emerald_bow", BowItem::new, new Item.Settings().maxDamage(768).enchantable(1));

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bluebell.MOD_ID, id));
    }

    public static Item register(String id, Function<Item.Settings, Item> factory) {
        return register(keyOf(id), factory, new Item.Settings());
    }

    public static Item register(String id, Item.Settings settings) {
        return register(keyOf(id), Item::new, settings);
    }

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = keyOf(id);
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static void initialize() {}
}