package com.annadach;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;


public class SelenideIssuesTest {

    @Test
    public void testRepositoryIssue() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("DachAnna/AllureReportsIssuesTests");
        $(".header-search-input").submit();
        $(linkText("DachAnna/AllureReportsIssuesTests")).click();
        $("#issues-tab").click();
        $("#issue_1_link").parent().shouldHave(text("#1"));
    }
}
