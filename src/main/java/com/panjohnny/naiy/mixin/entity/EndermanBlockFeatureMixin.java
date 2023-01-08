package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.DolphinHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndermanBlockFeatureRenderer.class)
public class EndermanBlockFeatureMixin {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/mob/EndermanEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, EndermanEntity endermanEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if(NAIY.getConfig().hideEndermanBlock) {
            ci.cancel();
        }
    }
}
