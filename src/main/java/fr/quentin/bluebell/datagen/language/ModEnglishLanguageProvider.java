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
        translationBuilder.add(ModItems.NETHERITE_HAMMER, "Netherite Hammer");

        translationBuilder.add(ModItemGroups.TOOLS.getDisplayName().getString(), "Bluebell Tools");
    }
}