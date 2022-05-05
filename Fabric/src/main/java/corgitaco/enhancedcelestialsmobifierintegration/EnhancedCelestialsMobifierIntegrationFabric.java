package corgitaco.enhancedcelestialsmobifierintegration;

import corgitaco.enhancedcelestialsmobifierintegration.network.FabricNetworkHandler;
import corgitaco.mobifier.common.MobifierRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class EnhancedCelestialsMobifierIntegrationFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        EnhancedCelestialsMobifierIntegration.init();
        FabricNetworkHandler.init();
        Registry.register(MobifierRegistry.CONDITION, new ResourceLocation(EnhancedCelestialsMobifierIntegration.MOD_ID, "lunar_event_is"), LunarEventCondition.CODEC);
    }
}
