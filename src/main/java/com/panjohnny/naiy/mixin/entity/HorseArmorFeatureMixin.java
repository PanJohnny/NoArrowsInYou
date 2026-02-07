package com.panjohnny.naiy.mixin.entity;

import com.panjohnny.naiy.NAIY;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SaddleFeatureRenderer.class)
public abstract class HorseArmorFeatureMixin {
    @Shadow
    @Final
    private EquipmentModel.LayerType layerType;

    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/LivingEntityRenderState;FF)V", at = @At("HEAD"), cancellable = true)
    public void naiy$doNotRenderHorseArmor(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, LivingEntityRenderState livingEntityRenderState, float f, float g, CallbackInfo ci) {
        if(this.layerType == EquipmentModel.LayerType.HORSE_BODY && NAIY.getConfig().hideHorseArmor) {
            ci.cancel();
        }
    }
}
