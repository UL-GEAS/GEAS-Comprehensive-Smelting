package com.geas.smelting.item;


import com.geas.smelting.GEAS_smelting;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

//Register for all items
public class ModItems {
    public static final DeferredRegister.Items  ITEMS =
            DeferredRegister.createItems(GEAS_smelting.MOD_ID);
//    Items go here:

    public static final DeferredItem<Item> CRUDE_IRON = ITEMS.register("crude_iron",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIER_1_IRON_POOR = ITEMS.register("tier_1_iron_poor",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIER_1_IRON_MEDIUM = ITEMS.register("tier_1_iron_medium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIER_1_IRON_PURE = ITEMS.register("tier_1_iron_pure",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }
}
