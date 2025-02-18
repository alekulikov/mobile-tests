package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {

    private final SelenideElement errorMessage = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));
    private final SelenideElement articleDescription = $(id("pcs-edit-section-title-description"));
    private final SelenideElement pageContent = $(id("android:id/content"));

    @Step("Проверить текст ошибки при открытии статьи")
    public ArticleScreen checkErrorMessage(String message) {
        errorMessage.shouldHave(text(message));
        return this;
    }

    @Step("Проверить, что краткое содержание статьи содержит {text}")
    public ArticleScreen checkArticleDescription(String text) {
        pageContent.click();
        articleDescription.shouldHave(text(text));
        return this;
    }
}
