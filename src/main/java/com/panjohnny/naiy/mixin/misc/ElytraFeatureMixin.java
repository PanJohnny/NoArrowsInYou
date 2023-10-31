package com.panjohnny.naiy.mixin.misc;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ElytraFeatureRenderer.class)
public abstract class ElytraFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderElytraWings(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, LivingEntity livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if(NAIY.isLocalPlayer(livingEntity) && NAIY.getConfig().hideElytra) {
            ci.cancel();
        }
    }
}
