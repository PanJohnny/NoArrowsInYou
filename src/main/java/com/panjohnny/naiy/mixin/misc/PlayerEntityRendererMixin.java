package com.panjohnny.naiy.mixin.misc;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {
    @Inject(method = "scale(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;)V", at = @At("TAIL"))
    public void naiy$resizePlayer(PlayerEntityRenderState playerEntityRenderState, MatrixStack matrixStack, CallbackInfo ci) {
        if (NAIY.isLocalPlayer(playerEntityRenderState) && NAIY.getConfig().resize) {
            matrixStack.scale(NAIY.getConfig().resX, NAIY.getConfig().resY, NAIY.getConfig().resZ);
        }
    }

    @Inject(method = "renderRightArm", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderRightArm(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, Identifier skinTexture, boolean sleeveVisible, CallbackInfo ci) {
        if(!NAIY.getConfig().rightArm) {
            ci.cancel();
        }
    }

    @Inject(method = "renderLeftArm", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderLeftArm(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, Identifier skinTexture, boolean sleeveVisible, CallbackInfo ci) {
        if(!NAIY.getConfig().leftArm) {
            ci.cancel();
        }
    }
}
