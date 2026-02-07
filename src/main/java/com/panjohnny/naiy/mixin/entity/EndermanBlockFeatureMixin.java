package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.render.entity.state.EndermanEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndermanBlockFeatureRenderer.class)
public abstract class EndermanBlockFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/EndermanEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderEndermanBlock(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, EndermanEntityRenderState endermanEntityRenderState, float f, float g, CallbackInfo ci) {
        if(NAIY.getConfig().hideEndermanBlock) {
            ci.cancel();
        }
    }
}
