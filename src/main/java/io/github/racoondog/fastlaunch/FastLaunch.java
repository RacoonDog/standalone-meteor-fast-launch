package io.github.racoondog.fastlaunch;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FastLaunch extends MeteorAddon {
    @Override
    public void onInitialize() {
    }

    @Override
    public String getPackage() {
        return "io.github.racoondog.fastlaunch";
    }
}
