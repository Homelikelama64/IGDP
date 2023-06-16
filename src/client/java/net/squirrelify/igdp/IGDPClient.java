package net.squirrelify.igdp;

import net.fabricmc.api.ClientModInitializer;
import net.squirrelify.igdp.events.KeyInputHandler;

public class IGDPClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}