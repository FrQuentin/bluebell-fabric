package fr.quentin.bluebell.datagen;

import fr.quentin.bluebell.item.ModItems;
import fr.quentin.bluebell.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItemTags.HAMMERS)
                .add(
                        ModItems.WOODEN_HAMMER,
                        ModItems.STONE_HAMMER,
                        ModItems.COPPER_HAMMER,
                        ModItems.IRON_HAMMER,
                        ModItems.GOLDEN_HAMMER,
                        ModItems.DIAMOND_HAMMER,
                        ModItems.NETHERITE_HAMMER
                );
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
    }
}