package com.annadach;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class LambdaStepIssuesTest {

    private final static String REPOSITORY = "DachAnna/AllureReportsIssuesTests";
    private final static Integer ISSUE_NUMBER = 1;

    @Test
    public void testRepositoryIssue() {
        step("Открываем главную страницу github.com", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем раздел Issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE_NUMBER, () -> {
            $("#issue_1_link").parent().shouldHave(text("#" + ISSUE_NUMBER));
        });
    }
}
