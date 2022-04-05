package com.panjohnny.naiy;

import com.panjohnny.naiy.config.NAIYConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class NAIY implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        AutoConfig.register(NAIYConfig.class, JanksonConfigSerializer::new);
    }

    public static NAIYConfig getConfig() {
        return AutoConfig.getConfigHolder(NAIYConfig.class).get();
    }

    public static boolean isLocalPlayer(Entity entity) {
        if(NAIY.getConfig().onlyLocal)
            return true;
        return MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player.getUuid().equals(entity.getUuid());
    }
}
