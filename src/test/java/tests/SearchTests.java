package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.MainScreen;
import screens.SearchScreen;

import static com.codeborne.selenide.Selenide.back;

@Feature("Главный экран")
@Story("Поиск")
@Owner("alekulikov")
@Link(value = "Testing", url = "https://github.com/alekulikov/mobile-tests")
class SearchTests extends TestBase {

    final MainScreen mainScreen = new MainScreen();
    final SearchScreen searchScreen = new SearchScreen();
    final ArticleScreen articleScreen = new ArticleScreen();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tags({
            @Tag("SMOKE"),
            @Tag("ANDROID")
    })
    @DisplayName("Успешный поиск по слову")
    void successfulSearchTest() {
        back();
        mainScreen.closeWindow()
                .openSearchScreen();
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
        back();
        mainScreen.closeWindow()
                .openSearchScreen();
        searchScreen.searchByText("Appium")
                .checkResultIsNotEmpty()
                .openFirstResult();
        articleScreen.checkArticleDescription("Automation for Apps");
    }
}