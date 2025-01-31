package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configs/auth.properties"
})
public interface AuthConfig extends Config {

    @Key("browserstack.userName")
    String username();

    @Key("browserstack.accessKey")
    String accessKey();
}
