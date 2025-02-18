package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configs/browserstack/android.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("browserstack.url")
    String url();

    @Key("browserstack.projectName")
    String projectName();

    @Key("browserstack.platformName")
    String platformName();

    @Key("browserstack.platformVersion")
    String platformVersion();

    @Key("browserstack.deviceName")
    String deviceName();

    @Key("browserstack.app")
    String app();
}
