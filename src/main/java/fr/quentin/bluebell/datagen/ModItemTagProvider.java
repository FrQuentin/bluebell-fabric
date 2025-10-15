package fr.quentin.bluebell.datagen;

import fr.quentin.bluebell.item.ModItems;
import fr.quentin.bluebell.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
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
                        ModItems.EMERALD_HAMMER,
                        ModItems.NETHERITE_HAMMER
                );
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        valueLookupBuilder(ModItemTags.EMERALD_TOOL_MATERIALS).add(Items.EMERALD);
        valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES).add(ModItems.EMERALD_PICKAXE);
        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.EMERALD_SWORD);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.EMERALD_SHOVEL);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.EMERALD_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.EMERALD_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.EMERALD_HOE);
        valueLookupBuilder(ModItemTags.REPAIRS_EMERALD_ARMOR).add(Items.EMERALD);
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.EMERALD_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.EMERALD_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.EMERALD_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.EMERALD_BOOTS);
    }
}