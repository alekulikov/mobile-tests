package configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigsProvider {

    public static final AuthConfig AUTH_CONFIG = ConfigFactory.create(AuthConfig.class,
            System.getProperties());
    public static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class,
            System.getProperties());
    public static final LocalConfig LOCAL_CONFIG = ConfigFactory.create(LocalConfig.class,
            System.getProperties());
}
