package com.panjohnny.naiy.mixin.misc;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeadFeatureRenderer.class)
public abstract class HeadFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/LivingEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderItemOnHead(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, LivingEntityRenderState livingEntityRenderState, float f, float g, CallbackInfo ci) {
        if(livingEntityRenderState instanceof PlayerEntityRenderState state && NAIY.isLocalPlayer(state) && NAIY.getConfig().hideHead) {
            ci.cancel();
        }
    }
}
