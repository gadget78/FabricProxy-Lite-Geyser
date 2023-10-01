package one.oktw.utils.platforms;

import org.geysermc.api.connection.Connection;
import org.geysermc.geyser.api.GeyserApi;

public class GeyserUtil implements PlatformUtil {
    @Override
    public String getBedrockPlayerPrefix() {
        return ".";
    }

    @Override
    public Long getXuid(String name) {
        for (Connection connection : GeyserApi.api().onlineConnections()) {
            if (connection.bedrockUsername().equals(name)) {
                try {
                    return Long.parseLong(connection.xuid());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        return null; //Not a Geyser player
    }
}
