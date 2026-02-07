package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.DolphinHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.state.DolphinEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DolphinHeldItemFeatureRenderer.class)
public abstract class DolphinHeldItemFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/DolphinEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderDolphinHeldItem(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, DolphinEntityRenderState dolphinEntityRenderState, float f, float g, CallbackInfo ci) {
        if(NAIY.getConfig().hideDolphinHeldItem) {
            ci.cancel();
        }
    }
}
