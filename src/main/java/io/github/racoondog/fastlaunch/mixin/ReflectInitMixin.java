package io.github.racoondog.fastlaunch.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import meteordevelopment.meteorclient.utils.ReflectInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(value = ReflectInit.class, remap = false)
public abstract class ReflectInitMixin {
    private static final Map<String, Reflections> FASTLAUNCH$REFLECTIONS_CACHE = new Object2ObjectOpenHashMap<>();

    @Redirect(method = "init", at = @At(value = "NEW", target = "org/reflections/Reflections"))
    private static Reflections cacheReflections(String prefix, Scanner[] scanners) {
        if (FASTLAUNCH$REFLECTIONS_CACHE.containsKey(prefix)) return FASTLAUNCH$REFLECTIONS_CACHE.get(prefix);
        Reflections reflections = new Reflections(prefix, scanners);
        FASTLAUNCH$REFLECTIONS_CACHE.put(prefix, reflections);
        return reflections;
    }
}
