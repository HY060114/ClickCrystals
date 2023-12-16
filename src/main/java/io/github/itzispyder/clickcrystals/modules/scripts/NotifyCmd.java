package io.github.itzispyder.clickcrystals.modules.scripts;

import io.github.itzispyder.clickcrystals.client.clickscript.ScriptArgs;
import io.github.itzispyder.clickcrystals.client.clickscript.ScriptCommand;
import io.github.itzispyder.clickcrystals.client.system.Notification;

public class NotifyCmd extends ScriptCommand {

    public NotifyCmd() {
        super("notify");
    }

    @Override
    public void onCommand(ScriptCommand command, String line, ScriptArgs args) {
        Notification.create()
                .ccsIcon()
                .stayTime((long)(args.get(0).doubleValue() * 1000L))
                .id("clickscript-triggered-notification")
                .title("ClickCrystals System")
                .text(args.getAll(1).stringValue())
                .build()
                .sendToClient();
    }
}
