package com.annadach;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу github.com")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем раздел Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $("#issue_1_link").parent().shouldHave(text("#" + number));
    }
}
