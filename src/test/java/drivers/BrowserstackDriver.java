package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
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
        try {
            return getMobileDriver(PLATFORM_CONFIG.platformName(), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver getMobileDriver(String platformName, MutableCapabilities capabilities) throws MalformedURLException {
        return switch (platformName) {
            case "android" -> getAndroidDriver(capabilities);
            case "ios" -> getIOSDriver(capabilities);
            default -> throw new IllegalStateException("Unexpected platform: " + PLATFORM_CONFIG.platformName());
        };
    }

    private AndroidDriver getAndroidDriver(MutableCapabilities capabilities) throws MalformedURLException {
        capabilities.setCapability("platformName", PLATFORM_CONFIG.platformName());
        capabilities.setCapability("appium:platformVersion", PLATFORM_CONFIG.platformVersion());
        capabilities.setCapability("appium:deviceName", PLATFORM_CONFIG.deviceName());
        capabilities.setCapability("appium:app", PLATFORM_CONFIG.app());
        return new AndroidDriver(new URL(PLATFORM_CONFIG.url()), capabilities);
    }

    private IOSDriver getIOSDriver(MutableCapabilities capabilities) throws MalformedURLException {
        capabilities.setCapability("platformName", PLATFORM_CONFIG.platformName());
        capabilities.setCapability("appium:platformVersion", PLATFORM_CONFIG.platformVersion());
        capabilities.setCapability("appium:deviceName", PLATFORM_CONFIG.deviceName());
        capabilities.setCapability("appium:app", PLATFORM_CONFIG.app());
        return new IOSDriver(new URL(PLATFORM_CONFIG.url()), capabilities);
    }
}
