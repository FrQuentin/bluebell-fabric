package fr.quentin.bluebell.mixin;

import com.mojang.authlib.GameProfile;
import fr.quentin.bluebell.item.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {
    private AbstractClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(
            method = "getFovMultiplier",
            at = @At("TAIL"),
            cancellable = true
    )
    private void getFovMultiplierMixin(boolean firstPerson, float fovEffectScale, CallbackInfoReturnable<Float> info) {
        ItemStack itemStack = this.getActiveItem();
        float f = info.getReturnValue();

        if (itemStack != null && this.isUsingItem() && itemStack.isOf(ModItems.EMERALD_BOW)) {
            float h = Math.min(this.getItemUseTime() / 20.0F, 1.0F);
            float zoom = 1.0F - MathHelper.square(h) * 0.15F;
            f *= zoom;
            info.setReturnValue(MathHelper.lerp(fovEffectScale, 1.0F, f));
        }
    }
}