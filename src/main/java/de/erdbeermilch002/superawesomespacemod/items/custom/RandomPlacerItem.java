package de.erdbeermilch002.superawesomespacemod.items.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class RandomPlacerItem extends Item {

    private static final Map<Block, Block> works_on = Map.of(
            Blocks.GRASS_BLOCK, Blocks.DIRT
    );

    public RandomPlacerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (works_on.containsKey(clickedBlock)) {
            //Only on Server
            if (!level.isClientSide) {
                //Switch clicked block with map pairs
                level.setBlockAndUpdate(context.getClickedPos(), works_on.get(clickedBlock).defaultBlockState());

                //damage item
                context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                //Sound
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
