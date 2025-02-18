package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {

    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));
    private final SelenideElement titleText = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("Проверить, что кнопка продолжить отображается")
    public OnboardingScreen checkContinueButtonVisible() {
        continueButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что кнопка продолжить не отображается")
    public OnboardingScreen checkContinueButtonNotVisible() {
        continueButton.shouldNotBe(visible);
        return this;
    }

    @Step("Кликнуть по кнопке продолжить")
    public OnboardingScreen clickContinueButton() {
        continueButton.click();
        return this;
    }

    @Step("Проверить, что кнопка начать отображается")
    public OnboardingScreen checkGetStartedButtonVisible() {
        getStartedButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что текст заголовка соответствует {text}")
    public OnboardingScreen checkTitleText(String text) {
        titleText.shouldBe(text(text));
        return this;
    }
}
