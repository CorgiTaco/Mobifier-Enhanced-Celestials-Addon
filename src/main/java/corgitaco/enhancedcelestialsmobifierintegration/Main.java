package corgitaco.enhancedcelestialsmobifierintegration;

import corgitaco.mobifier.common.MobifierRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "enhanced_celestials_mobifier_integration";

    public Main() {
        Registry.register(MobifierRegistry.CONDITION, new ResourceLocation(MOD_ID, "lunar_event_is"), LunarEventCondition.CODEC);
    }
}