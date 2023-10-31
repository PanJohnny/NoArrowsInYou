package com.panjohnny.naiy.mixin.misc;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {
    @Inject(method = "scale(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/util/math/MatrixStack;F)V", at = @At("TAIL"))
    public void naiy$resizePlayer(LivingEntity entity, MatrixStack matrices, float amount, CallbackInfo ci) {
        if (NAIY.isLocalPlayer(entity) && NAIY.getConfig().resize) {
            matrices.scale(NAIY.getConfig().resX, NAIY.getConfig().resY, NAIY.getConfig().resZ);
        }
    }

    @Inject(method = "renderRightArm", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderRightArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player,CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().rightArm) {
            ci.cancel();
        }
    }

    @Inject(method = "renderLeftArm", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderLeftArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player,CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().leftArm) {
            ci.cancel();
        }
    }

    @Inject(method="render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at=@At("HEAD"), cancellable = true)
    public void naiy$doNotRenderPlayer(AbstractClientPlayerEntity player, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(player) && !NAIY.getConfig().render) {
            ci.cancel();
        }
    }
}
