package corgitaco.enhancedcelestialsmobifierintegration;

import corgitaco.enhancedcelestialsmobifierintegration.network.ForgeNetworkHandler;
import corgitaco.mobifier.common.MobifierRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnhancedCelestialsMobifierIntegration.MOD_ID)
public class ExampleModForge {

    public ExampleModForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        EnhancedCelestialsMobifierIntegration.LOGGER.info("Hello Forge world!");
        EnhancedCelestialsMobifierIntegration.init();
        Registry.register(MobifierRegistry.CONDITION, new ResourceLocation(EnhancedCelestialsMobifierIntegration.MOD_ID, "lunar_event_is"), LunarEventCondition.CODEC);
    }


    private void commonSetup(FMLCommonSetupEvent event) {
        ForgeNetworkHandler.init();
    }
}