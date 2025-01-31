package configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigsProvider {

    public static final AuthConfig AUTH_CONFIG = ConfigFactory.create(AuthConfig.class,
            System.getProperties());
    public static final PlatformConfig PLATFORM_CONFIG = ConfigFactory.create(PlatformConfig.class,
            System.getProperties());
}
