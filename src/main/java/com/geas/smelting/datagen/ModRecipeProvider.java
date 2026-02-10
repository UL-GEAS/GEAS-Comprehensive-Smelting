package com.geas.smelting.datagen;


import com.geas.smelting.GEAS_smelting;
import com.geas.smelting.block.ModBlocks;
import com.geas.smelting.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes( RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIER_1_FOUNDRY.get())
                .pattern("ISI")
                .pattern("SCS")
                .pattern("ISI")
                .define('I', ModItems.CRUDE_IRON.get())
                .define('S', Items.COBBLESTONE)
                .define('C', Items.COAL)
                .unlockedBy("has_crude_iron", has(ModItems.CRUDE_IRON)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 1)
                .requires(ModItems.TIER_1_IRON_POOR)
                .group("bloom_refining")
                .unlockedBy("has_bloom", has(ModItems.TIER_1_IRON_POOR)).save(recipeOutput, "iron_ingot_from_poor_bloom");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 2)
                .requires(ModItems.TIER_1_IRON_MEDIUM)
                .group("bloom_refining")
                .unlockedBy("has_bloom", has(ModItems.TIER_1_IRON_MEDIUM)).save(recipeOutput, "iron_ingot_from_medium_bloom");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT,3)
                .requires(ModItems.TIER_1_IRON_PURE)
                .group("bloom_refining")
                .unlockedBy("has_bloom", has(ModItems.TIER_1_IRON_PURE)).save(recipeOutput, "iron_ingot_from_pure_bloom");



    }

//    Helper methods
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, GEAS_smelting.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}


