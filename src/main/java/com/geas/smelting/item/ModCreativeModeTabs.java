package com.geas.smelting.item;



import com.geas.smelting.GEAS_smelting;
import com.geas.smelting.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GEAS_smelting.MOD_ID);

    public static final Supplier<CreativeModeTab> SMELTING_ITEMS_TAB = CREATIVE_MODE_TAB.register("smelting_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRUDE_IRON.get()))
                    .title(Component.translatable("creativetab.GEAS_smelting.smelting_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                    //Put items here:
                    output.accept(ModItems.CRUDE_IRON);


            }).build());
    public static final Supplier<CreativeModeTab> SMELTING_BLOCKS_TAB = CREATIVE_MODE_TAB.register("smelting_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIER_1_FOUNDRY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GEAS_smelting.MOD_ID, "smelting_items_tab"))
                    .title(Component.translatable("creativetab.GEAS_smelting.smelting_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                    //Put blocks here:
                    output.accept(ModBlocks.TIER_1_FOUNDRY);





            }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
