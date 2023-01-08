package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.DolphinHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.feature.FoxHeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.FoxEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoxHeldItemFeatureRenderer.class)
public class FoxHeldItemFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/passive/FoxEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, FoxEntity foxEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if(NAIY.getConfig().hideFoxHeldItem) {
            ci.cancel();
        }
    }
}
