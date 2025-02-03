package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {

    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Выполнить поиск по строке")
    public SearchScreen searchByText(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    @Step("Проверить, что результаты найдены")
    public SearchScreen checkResultIsNotEmpty() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открыть первый результат поиска")
    public void openFirstResult() {
        searchResults.first().click();
    }
}
