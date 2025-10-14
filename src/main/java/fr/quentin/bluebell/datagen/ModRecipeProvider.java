package fr.quentin.bluebell.datagen;

import fr.quentin.bluebell.Bluebell;
import fr.quentin.bluebell.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.WOODEN_HAMMER, ingredientFromTag(ItemTags.PLANKS))
                        .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                        .offerTo(exporter);
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.STONE_HAMMER, ingredientFromTag(ItemTags.STONE_CRAFTING_MATERIALS))
                        .criterion("has_stone", conditionsFromTag(ItemTags.STONE_CRAFTING_MATERIALS))
                        .offerTo(exporter);
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.COPPER_HAMMER, Ingredient.ofItem(Items.COPPER_INGOT))
                        .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.IRON_HAMMER, Ingredient.ofItem(Items.IRON_INGOT))
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.GOLDEN_HAMMER, Ingredient.ofItem(Items.GOLD_INGOT))
                        .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                        .offerTo(exporter);
                createHammerItemRecipe(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER, Ingredient.ofItem(Items.DIAMOND))
                        .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);
                offerNetheriteUpgradeRecipe(ModItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER);
            }
            public ShapedRecipeJsonBuilder createHammerItemRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
                return createShaped(category, output)
                        .input('M', input)
                        .input('S', Items.STICK)
                        .pattern("MMM")
                        .pattern("MSM")
                        .pattern(" S ");
            }
        };
    }

    @Override
    public String getName() {
        return Bluebell.MOD_ID + " recipes";
    }
}