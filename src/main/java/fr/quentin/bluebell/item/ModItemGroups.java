package fr.quentin.bluebell.item;

import fr.quentin.bluebell.Bluebell;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> ITEMS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Bluebell.MOD_ID, "bluebell_items"));
    public static final ItemGroup ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.EMERALD_HAMMER))
            .displayName(Text.translatable("itemGroup.bluebell_items"))
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, ITEMS_KEY, ITEMS);

        ItemGroupEvents.modifyEntriesEvent(ITEMS_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.WOODEN_HAMMER);
            itemGroup.add(ModItems.STONE_HAMMER);
            itemGroup.add(ModItems.COPPER_HAMMER);
            itemGroup.add(ModItems.IRON_HAMMER);
            itemGroup.add(ModItems.GOLDEN_HAMMER);
            itemGroup.add(ModItems.DIAMOND_HAMMER);
            itemGroup.add(ModItems.EMERALD_HAMMER);
            itemGroup.add(ModItems.NETHERITE_HAMMER);
            itemGroup.add(ModItems.EMERALD_SWORD);
            itemGroup.add(ModItems.EMERALD_SHOVEL);
            itemGroup.add(ModItems.EMERALD_PICKAXE);
            itemGroup.add(ModItems.EMERALD_AXE);
            itemGroup.add(ModItems.EMERALD_HOE);
            itemGroup.add(ModItems.EMERALD_HELMET);
            itemGroup.add(ModItems.EMERALD_CHESTPLATE);
            itemGroup.add(ModItems.EMERALD_LEGGINGS);
            itemGroup.add(ModItems.EMERALD_BOOTS);
        });
    }
}