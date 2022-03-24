package com.panjohnny.naiy;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class NAIYUtil {
    public static boolean isLocalPlayer(Entity entity) {
        return MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player.getUuid().equals(entity.getUuid());
    }
}
