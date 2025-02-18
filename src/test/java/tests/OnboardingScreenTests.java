package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

@Feature("Приветственный экран")
@Story("Конфигурация")
@Owner("alekulikov")
@Link(value = "Testing", url = "https://github.com/alekulikov/mobile-tests")
class OnboardingScreenTests extends TestBase {

    final OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tags({
            @Tag("SMOKE"),
            @Tag("ANDROID")
    })
    @DisplayName("Успешная первоначальная конфигурация")
    void successOnboardingTest() {
        onboardingScreen.checkTitleText("The Free Encyclopedia\n…in over 300 languages")
                .checkContinueButtonVisible()
                .clickContinueButton()
                .checkTitleText("New ways to explore")
                .clickContinueButton()
                .checkTitleText("Reading lists with sync")
                .clickContinueButton()
                .checkTitleText("Data & Privacy")
                .checkContinueButtonNotVisible()
                .checkGetStartedButtonVisible();
    }
}
