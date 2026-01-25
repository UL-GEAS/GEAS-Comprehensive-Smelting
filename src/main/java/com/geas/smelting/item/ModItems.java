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



    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }
}
