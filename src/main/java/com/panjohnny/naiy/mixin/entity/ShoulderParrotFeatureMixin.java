package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.ShoulderParrotFeatureRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShoulderParrotFeatureRenderer.class)
public abstract class ShoulderParrotFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/PlayerEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderShoulderParrot(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, PlayerEntityRenderState playerEntityRenderState, float f, float g, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(playerEntityRenderState) && NAIY.getConfig().hideShoulderParrot) {
            ci.cancel();
        }
    }

    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/entity/passive/ParrotEntity$Variant;FFZ)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderShoulderParrot2(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, PlayerEntityRenderState state, ParrotEntity.Variant parrotVariant, float headYaw, float headPitch, boolean left, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(state) && NAIY.getConfig().hideShoulderParrot) {
            ci.cancel();
        }
    }
}
