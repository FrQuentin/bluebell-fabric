package fr.quentin.bluebell.datagen;

import fr.quentin.bluebell.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModBlockTags.NEEDS_EMERALD_TOOL)
                .add(
                        Blocks.OBSIDIAN,
                        Blocks.CRYING_OBSIDIAN,
                        Blocks.NETHERITE_BLOCK,
                        Blocks.RESPAWN_ANCHOR,
                        Blocks.ANCIENT_DEBRIS
                );
        valueLookupBuilder(ModBlockTags.INCORRECT_FOR_EMERALD_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL).addTag(ModBlockTags.NEEDS_EMERALD_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL).addTag(ModBlockTags.NEEDS_EMERALD_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_COPPER_TOOL).addTag(ModBlockTags.NEEDS_EMERALD_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTag(ModBlockTags.NEEDS_EMERALD_TOOL);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addTag(ModBlockTags.NEEDS_EMERALD_TOOL);
    }
}