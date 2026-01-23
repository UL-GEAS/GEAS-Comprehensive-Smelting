package com.geas.smelting.datagen;

import com.geas.smelting.GEAS_smelting;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GEAS_smelting.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Put items here:
//        basicItem(ModItems.PLACHOLDER.get());
//        Placeholder code so i dont forget how it works
//        handheldItem(ModItems.PLACHOLDER);

    }



        //Helper methods
        public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
            this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                    .texture("texture",  ResourceLocation.fromNamespaceAndPath(GEAS_smelting.MOD_ID,
                            "block/" + baseBlock.getId().getPath()));
        }

        public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
            this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                    .texture("texture",  ResourceLocation.fromNamespaceAndPath(GEAS_smelting.MOD_ID,
                            "block/" + baseBlock.getId().getPath()));
        }

        public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
            this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                    .texture("wall",  ResourceLocation.fromNamespaceAndPath(GEAS_smelting.MOD_ID,
                            "block/" + baseBlock.getId().getPath()));
        }

        private ItemModelBuilder handheldItem(DeferredItem<?> item){
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.parse("item/handheld")).texture("layer0",
                    ResourceLocation.fromNamespaceAndPath(GEAS_smelting.MOD_ID,"item/" + item.getId().getPath()));
        }
}

