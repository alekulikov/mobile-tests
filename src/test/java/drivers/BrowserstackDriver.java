package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static configs.ConfigsProvider.AUTH_CONFIG;
import static configs.ConfigsProvider.PLATFORM_CONFIG;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        var caps = new DesiredCapabilities();
        var bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", AUTH_CONFIG.username());
        bstackOptions.put("accessKey", AUTH_CONFIG.accessKey());
        bstackOptions.put("projectName", PLATFORM_CONFIG.projectName());
        caps.setCapability("bstack:options", bstackOptions);
        caps.setCapability("platformName", PLATFORM_CONFIG.platformName());
        caps.setCapability("appium:platformVersion", PLATFORM_CONFIG.platformVersion());
        caps.setCapability("appium:deviceName", PLATFORM_CONFIG.deviceName());
        caps.setCapability("appium:app", PLATFORM_CONFIG.app());
        try {
            return new AndroidDriver(new URL(PLATFORM_CONFIG.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
