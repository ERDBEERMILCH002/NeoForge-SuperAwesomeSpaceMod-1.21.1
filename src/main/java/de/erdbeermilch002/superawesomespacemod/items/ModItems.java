package de.erdbeermilch002.superawesomespacemod.items;

import de.erdbeermilch002.superawesomespacemod.SuperAwesomeSpaceMod;
import de.erdbeermilch002.superawesomespacemod.items.custom.RandomPlacerItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //Telling minecraft to add these custom items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SuperAwesomeSpaceMod.MODID);

    public static final DeferredItem<Item> ALIEN_GEM = ITEMS.register("alien_gem",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ALIEN_GEM = ITEMS.register("raw_alien_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RANDOM_PLACER = ITEMS.register("random_placer",
            () -> new RandomPlacerItem(new Item.Properties().durability(64)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
