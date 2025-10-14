package fr.quentin.bluebell.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HammerItem extends Item {
    private static final Map<Direction, List<BlockPos>> PATTERN_CACHE = new HashMap<>();

    static {
        int range = 1;

        List<BlockPos> upDownPattern = new ArrayList<>();
        for(int x = -range; x <= range; x++) {
            for(int z = -range; z <= range; z++) {
                upDownPattern.add(new BlockPos(x, 0, z));
            }
        }
        PATTERN_CACHE.put(Direction.UP, Collections.unmodifiableList(upDownPattern));
        PATTERN_CACHE.put(Direction.DOWN, Collections.unmodifiableList(upDownPattern));

        List<BlockPos> northSouthPattern = new ArrayList<>();
        for(int x = -range; x <= range; x++) {
            for(int y = -range; y <= range; y++) {
                northSouthPattern.add(new BlockPos(x, y, 0));
            }
        }
        PATTERN_CACHE.put(Direction.NORTH, Collections.unmodifiableList(northSouthPattern));
        PATTERN_CACHE.put(Direction.SOUTH, Collections.unmodifiableList(northSouthPattern));

        List<BlockPos> eastWestPattern = new ArrayList<>();
        for(int z = -range; z <= range; z++) {
            for(int y = -range; y <= range; y++) {
                eastWestPattern.add(new BlockPos(0, y, z));
            }
        }
        PATTERN_CACHE.put(Direction.EAST, Collections.unmodifiableList(eastWestPattern));
        PATTERN_CACHE.put(Direction.WEST, Collections.unmodifiableList(eastWestPattern));
    }

    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            Direction side = blockHit.getSide();

            List<BlockPos> pattern = PATTERN_CACHE.get(side);

            if(pattern != null) {
                for(BlockPos relativePos : pattern) {
                    positions.add(initialBlockPos.add(relativePos));
                }
            }
        }

        return positions;
    }
}