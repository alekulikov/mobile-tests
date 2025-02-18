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
import static configs.ConfigsProvider.BROWSERSTACK_CONFIG;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        var caps = new DesiredCapabilities();
        var bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", AUTH_CONFIG.username());
        bstackOptions.put("accessKey", AUTH_CONFIG.accessKey());
        bstackOptions.put("projectName", BROWSERSTACK_CONFIG.projectName());
        bstackOptions.put("appiumVersion", "2.0.1");
        caps.setCapability("bstack:options", bstackOptions);
        caps.setCapability("platformName", BROWSERSTACK_CONFIG.platformName());
        caps.setCapability("appium:platformVersion", BROWSERSTACK_CONFIG.platformVersion());
        caps.setCapability("appium:deviceName", BROWSERSTACK_CONFIG.deviceName());
        caps.setCapability("appium:app", BROWSERSTACK_CONFIG.app());
        caps.setCapability("appium:automationName", "UIAutomator2");
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        try {
            return new AndroidDriver(new URL(BROWSERSTACK_CONFIG.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
