package com.panjohnny.naiy.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "naiy")
public class NAIYConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category(value = "general")
    public boolean onlyLocal = true;
    @ConfigEntry.Category(value = "general")
    public boolean hideArrows = true;
    @ConfigEntry.Category(value = "general")
    public boolean hideStings = true;
    @ConfigEntry.Category(value = "misc")
    public boolean hideArmor = false;
    @ConfigEntry.Category(value = "misc")
    public boolean hideHeldItem = false;
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Category(value = "misc")
    public boolean hideHead = false;
    @ConfigEntry.Category(value = "misc")
    public boolean hideElytra = false;
    @ConfigEntry.Category(value = "misc")
    public boolean hideRiptide = false;

    @ConfigEntry.Category(value = "misc")
    public boolean render = true;

    /*
     * Entities
     */
    @ConfigEntry.Category(value = "entity")
    public boolean hideShoulderParrot = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideHorseArmor = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideCatCollar = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideWolfCollar = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideDolphinHeldItem = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideFoxHeldItem = false;

    @ConfigEntry.Category(value = "entity")
    public boolean hideEndermanBlock = false;


    @ConfigEntry.Category(value = "res")
    public boolean resize = false;
    @ConfigEntry.Category(value = "res")
    @ConfigEntry.BoundedDiscrete(max = 100L)
    public int resX = 1;
    @ConfigEntry.Category(value = "res")
    @ConfigEntry.BoundedDiscrete(max = 100L)
    public int resY = 1;
    @ConfigEntry.Category(value = "res")
    @ConfigEntry.BoundedDiscrete(max = 100L)
    public int resZ = 1;

    @ConfigEntry.Category(value = "hands")
    public boolean rightArm = true;
    @ConfigEntry.Category(value = "hands")
    public boolean leftArm = true;
}
