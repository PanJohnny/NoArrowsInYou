package com.panjohnny.naiy.mixin.general;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.entity.feature.StuckArrowsFeatureRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StuckArrowsFeatureRenderer.class)
public abstract class StuckArrowsFeatureMixin {
    @Inject(method = "getObjectCount", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderStuckArrows(PlayerEntityRenderState playerRenderState, CallbackInfoReturnable<Integer> cir) {
        if (NAIY.isLocalPlayer(playerRenderState) && NAIY.getConfig().hideArrows) {
            cir.setReturnValue(0);
            cir.cancel();
        }
    }
}
