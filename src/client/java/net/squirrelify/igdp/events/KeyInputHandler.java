package net.squirrelify.igdp.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MOVEMENT = "key.category.igdp.movement";
    public static final String KEY_JUMP = "key.igdp.jump";

    public static KeyBinding jumpKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                if (jumpKey.wasPressed()) {
                    client.player.jump();
                }
            }
        });
    }

    public static void register() {
        jumpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_JUMP,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_SPACE,
            KEY_CATEGORY_MOVEMENT
        ));

        registerKeyInputs();
    }
}
