package io.github.itzispyder.clickcrystals.gui.elements.cc.settings;

import io.github.itzispyder.clickcrystals.gui.GuiElement;
import io.github.itzispyder.clickcrystals.modules.settings.Setting;
import io.github.itzispyder.clickcrystals.modules.settings.SettingGroup;
import io.github.itzispyder.clickcrystals.util.DrawableUtils;
import net.minecraft.client.gui.DrawContext;

import static io.github.itzispyder.clickcrystals.ClickCrystals.mc;

public class SettingGroupElement extends GuiElement {

    private final SettingGroup settingGroup;
    private float textScale;

    public SettingGroupElement(SettingGroup settingGroup, int x, int y, int width, int height, float textScale) {
        super(x, y, width, height);
        this.settingGroup = settingGroup;
        this.textScale = textScale;

        int nameHeight = (int)(10 * textScale);
        int caret = y + nameHeight + 2;

        for (Setting<?> setting : settingGroup.getSettings()) {
            GuiElement element = setting.toGuiElement(x, caret, 20, 10);
            this.addChild(element);
            caret += element.height + 2;
        }
        this.height = caret - y;
    }

    @Override
    public void onRender(DrawContext context, int mouseX, int mouseY) {
        String name = settingGroup.getName();
        int nameWidth = (int)(mc.textRenderer.getWidth(name) * textScale);
        int nameHeight = (int)(10 * textScale);
        int textMargin = (int)(width * 0.05);

        DrawableUtils.drawHorizontalLine(context, x, y + nameHeight / 2, textMargin, 1, 0xFFFFFFFF);
        DrawableUtils.drawText(context, name, x + textMargin + 3, y + nameHeight / 4, textScale, true);
        DrawableUtils.drawHorizontalLine(context, x + textMargin + nameWidth + 6, y + nameHeight / 2, width - (textMargin + nameWidth + 16), 1, 0xFFFFFFFF);
    }

    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        for (GuiElement child : this.getChildren()) {
            if (child.isHovered((int)mouseX, (int)mouseY)) {
                child.onClick(mouseX, mouseY, button);
                break;
            }
        }
    }

    public SettingGroup getSettingGroup() {
        return settingGroup;
    }
}
