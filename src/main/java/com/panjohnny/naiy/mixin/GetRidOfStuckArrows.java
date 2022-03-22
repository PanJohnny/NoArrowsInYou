package com.panjohnny.naiy.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.StuckArrowsFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StuckArrowsFeatureRenderer.class)
public class GetRidOfStuckArrows {
    @Inject(method = "renderObject", at = @At("HEAD"), cancellable = true)
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Entity entity, float directionX, float directionY, float directionZ, float tickDelta, CallbackInfo ci) {
        if (MinecraftClient.getInstance().player != null && entity.getType() == EntityType.PLAYER && MinecraftClient.getInstance().player.getUuid().equals(entity.getUuid())) {
            ci.cancel();
        }
    }
}
