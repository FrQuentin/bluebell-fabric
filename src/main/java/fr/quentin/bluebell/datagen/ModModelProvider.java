package fr.quentin.bluebell.datagen;

import fr.quentin.bluebell.item.ModItems;
import fr.quentin.bluebell.item.equipment.ModEquipmentAssetKeys;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WOODEN_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.STONE_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.COPPER_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.IRON_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.GOLDEN_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.EMERALD_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.NETHERITE_HAMMER, Models.HANDHELD_MACE);
        itemModelGenerator.register(ModItems.EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(ModItems.EMERALD_HELMET, ModEquipmentAssetKeys.EMERALD, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EMERALD_CHESTPLATE, ModEquipmentAssetKeys.EMERALD, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EMERALD_LEGGINGS, ModEquipmentAssetKeys.EMERALD, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.EMERALD_BOOTS, ModEquipmentAssetKeys.EMERALD, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.register(ModItems.EMERALD_HORSE_ARMOR, Models.GENERATED);
    }
}