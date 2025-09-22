package de.erdbeermilch002.superawesomespacemod.items;

import de.erdbeermilch002.superawesomespacemod.SuperAwesomeSpaceMod;
import de.erdbeermilch002.superawesomespacemod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperAwesomeSpaceMod.MODID);

    public static final Supplier<CreativeModeTab> SUPER_AWESOME_SPACE_ITEMS = CREATIVE_MODE_TAB.register("super_awesome_space_items",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ALIEN_GEM.get()))
                    .title(Component.translatable("creativetab.superawesomespacemod.super_awesome_space_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ALIEN_GEM);
                        output.accept(ModItems.RAW_ALIEN_GEM);
                        output.accept(ModItems.RANDOM_PLACER);

                    }).build());

    public static final Supplier<CreativeModeTab> SUPER_AWESOME_SPACE_BLOCKS = CREATIVE_MODE_TAB.register("super_awesome_space_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ALIEN_GEM_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SuperAwesomeSpaceMod.MODID, "super_awesome_space_items"))
                    .title(Component.translatable("creativetab.superawesomespacemod.super_awesome_space_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.ALIEN_GEM_BLOCK);
                        output.accept(ModBlocks.ALIEN_GEM_ORE);
                        output.accept(ModBlocks.ALIEN_GEM_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
