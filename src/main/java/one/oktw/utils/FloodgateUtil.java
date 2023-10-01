package one.oktw.utils;

import org.geysermc.floodgate.api.FloodgateApi;

public class FloodgateUtil implements PlatformUtil {
    @Override
    public String getBedrockPlayerPrefix() {
        return FloodgateApi.getInstance().getPlayerPrefix();
    }

    @Override
    public Long getXuid(String name) {
        try {
            return FloodgateApi.getInstance().getXuidFor(name).join();
        } catch (Exception e) { //Not a Floodgate player
            return null;
        }
    }
}
