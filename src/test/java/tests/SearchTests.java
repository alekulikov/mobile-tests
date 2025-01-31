package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.MainScreen;
import screens.SearchScreen;

@Feature("Главный экран")
@Story("Поиск")
@Owner("alekulikov")
@Link(value = "Testing", url = "https://github.com/alekulikov/mobile-tests-browserstack")
class SearchTests extends TestBase {

    final MainScreen mainScreen = new MainScreen();
    final SearchScreen searchScreen = new SearchScreen();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tags({
            @Tag("SMOKE"),
            @Tag("ANDROID")
    })
    @DisplayName("Успешный поиск по слову")
    void successfulSearchTest() {
        mainScreen.openSearchScreen();
        searchScreen.searchByText("Appium")
                .checkResultIsNotEmpty();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tags({
            @Tag("SMOKE"),
            @Tag("ANDROID")
    })
    @DisplayName("Открытие результата поиска")
    void successfulOpenResultSearchTest() {
        mainScreen.openSearchScreen();
        searchScreen.searchByText("Appium")
                .checkResultIsNotEmpty()
                .openFirstResult()
                .checkErrorMessage("An error occurred");
    }
}