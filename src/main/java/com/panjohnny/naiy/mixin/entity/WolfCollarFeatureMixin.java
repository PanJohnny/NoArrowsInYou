package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.WolfCollarFeatureRenderer;
import net.minecraft.client.render.entity.state.WolfEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WolfCollarFeatureRenderer.class)
public abstract class WolfCollarFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/WolfEntityRenderState;FF)V", at = @At("HEAD"), cancellable=true)
    public void naiy$doNotRenderWolfCollar(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, WolfEntityRenderState wolfEntityRenderState, float f, float g, CallbackInfo ci) {
        if(NAIY.getConfig().hideWolfCollar) {
            ci.cancel();
        }
    }
}
