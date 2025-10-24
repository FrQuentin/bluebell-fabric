package fr.quentin.bluebell.datagen.language;

import fr.quentin.bluebell.item.ModItemGroups;
import fr.quentin.bluebell.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLanguageProvider extends FabricLanguageProvider {
    public ModEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.WOODEN_HAMMER, "Wooden Hammer");
        translationBuilder.add(ModItems.STONE_HAMMER, "Stone Hammer");
        translationBuilder.add(ModItems.COPPER_HAMMER, "Copper Hammer");
        translationBuilder.add(ModItems.IRON_HAMMER, "Iron Hammer");
        translationBuilder.add(ModItems.GOLDEN_HAMMER, "Golden Hammer");
        translationBuilder.add(ModItems.DIAMOND_HAMMER, "Diamond Hammer");
        translationBuilder.add(ModItems.EMERALD_HAMMER, "Emerald Hammer");
        translationBuilder.add(ModItems.NETHERITE_HAMMER, "Netherite Hammer");
        translationBuilder.add(ModItems.EMERALD_SWORD, "Emerald Sword");
        translationBuilder.add(ModItems.EMERALD_SHOVEL, "Emerald Shovel");
        translationBuilder.add(ModItems.EMERALD_PICKAXE, "Emerald Pickaxe");
        translationBuilder.add(ModItems.EMERALD_AXE, "Emerald Axe");
        translationBuilder.add(ModItems.EMERALD_HOE, "Emerald Hoe");
        translationBuilder.add(ModItems.EMERALD_HELMET, "Emerald Helmet");
        translationBuilder.add(ModItems.EMERALD_CHESTPLATE, "Emerald Chestplate");
        translationBuilder.add(ModItems.EMERALD_LEGGINGS, "Emerald Leggings");
        translationBuilder.add(ModItems.EMERALD_BOOTS, "Emerald Boots");
        translationBuilder.add(ModItems.EMERALD_HORSE_ARMOR, "Emerald Horse Armor");
        translationBuilder.add(ModItems.EMERALD_BOW, "Emerald Bow");

        translationBuilder.add(ModItemGroups.ITEMS.getDisplayName().getString(), "Bluebell Items");

        translationBuilder.add("tag.item.bluebell.hammers", "Hammers");
        translationBuilder.add("tag.item.bluebell.emerald_tool_materials", "Emerald Tool Materials");
        translationBuilder.add("tag.item.bluebell.repairs_emerald_armor", "Repairs Emerald Armor");
        translationBuilder.add("tag.block.bluebell.needs_emerald_tool", "Blocks Requiring Emerald Tool");
        translationBuilder.add("tag.block.bluebell.incorrect_for_emerald_tool", "Incorrect for Emerald Tool");
    }
}