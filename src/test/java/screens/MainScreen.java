package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement searchField = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement windowsCloseButton = $(id("org.wikipedia.alpha:id/closeButton"));

    @Step("Кликнуть по строке поиска")
    public void openSearchScreen() {
        searchField.click();
    }

    @Step("Закрыть рекламное окно, если оно появилось")
    public MainScreen closeWindow() {
        if (windowsCloseButton.isDisplayed()) {
            windowsCloseButton.click();
        }
        return this;
    }
}
