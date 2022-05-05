package corgitaco.enhancedcelestialsmobifierintegration.platform;

import corgitaco.enhancedcelestialsmobifierintegration.network.FabricNetworkHandler;
import corgitaco.enhancedcelestialsmobifierintegration.network.S2CPacket;
import corgitaco.enhancedcelestialsmobifierintegration.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.level.ServerPlayer;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <P extends S2CPacket> void sendToClient(ServerPlayer player, P packet) {
        FabricNetworkHandler.sendToPlayer(player, packet);
    }
}
