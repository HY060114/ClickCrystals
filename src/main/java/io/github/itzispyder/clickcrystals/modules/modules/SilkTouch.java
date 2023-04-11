package io.github.itzispyder.clickcrystals.modules.modules;

import io.github.itzispyder.clickcrystals.modules.Categories;
import io.github.itzispyder.clickcrystals.modules.Module;
import io.github.itzispyder.clickcrystals.util.ChatUtils;

/**
 * Silk Touch module
 */
public class SilkTouch extends Module {

    public SilkTouch() {
        super("SilkTouch", Categories.DETECTABLE,"\"Makes any of your tools silk touch\"");
    }

    @Override
    protected void onEnable() {
        super.setEnabled(false);
        ChatUtils.sendChatMessage("I just made my weapon silk touch! This is not possible and will now crash my game.");
        System.exit(-1);
    }

    @Override
    protected void onDisable() {

    }
}
