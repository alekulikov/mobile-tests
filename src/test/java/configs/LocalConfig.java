package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/local/android.properties"
})
public interface LocalConfig extends Config {

    @Key("local.platformVersion")
    String platformVersion();

    @Key("local.deviceName")
    String deviceName();

    @Key("local.udid")
    String udid();

    @Key("local.appPackage")
    String appPackage();

    @Key("local.appActivity")
    String appActivity();
}
