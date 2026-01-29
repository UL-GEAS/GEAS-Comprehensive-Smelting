package com.geas.smelting.datagen;


import com.geas.smelting.GEAS_smelting;
import com.geas.smelting.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GEAS_smelting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIER_1_FOUNDRY.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIER_1_FOUNDRY.get());
//
//        tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.PLACEHOLDER.get());







    }
}
