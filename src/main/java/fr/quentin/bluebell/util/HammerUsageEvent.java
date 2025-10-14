package fr.quentin.bluebell.util;

import fr.quentin.bluebell.item.custom.HammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HammerUsageEvent implements PlayerBlockBreakEvents.Before{
    private static final Map<UUID, Set<BlockPos>> HARVESTED_BLOCKS = new ConcurrentHashMap<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayerEntity serverPlayer) {
            Set<BlockPos> playerHarvestedBlocks = HARVESTED_BLOCKS.computeIfAbsent(
                    serverPlayer.getUuid(),
                    k -> new HashSet<>()
            );

            if(playerHarvestedBlocks.contains(pos)) {
                return true;
            }

            for(BlockPos position : HammerItem.getBlocksToBeDestroyed(pos, serverPlayer)) {
                if(pos.equals(position) || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                playerHarvestedBlocks.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                playerHarvestedBlocks.remove(position);
            }
        }

        return true;
    }

    public static void removePlayer(UUID playerUuid) {
        HARVESTED_BLOCKS.remove(playerUuid);
    }

    public static void registerCleanupEvent() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server)
                -> removePlayer(handler.player.getUuid()));
    }
}