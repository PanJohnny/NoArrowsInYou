package com.panjohnny.naiy.mixin.misc;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ElytraFeatureRenderer.class)
public abstract class ElytraFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/BipedEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderElytraWings(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, BipedEntityRenderState bipedEntityRenderState, float f, float g, CallbackInfo ci) {
        if(bipedEntityRenderState instanceof PlayerEntityRenderState state && NAIY.isLocalPlayer(state) && NAIY.getConfig().hideElytra) {
            ci.cancel();
        }
    }
}
