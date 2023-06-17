package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://github.com");
        $$(".HeaderMenu-item").findBy(text("Solution")).hover();
        $("[href='/enterprise']").click();
        //$(byText("Enterprise")).click();
        $(byText("Build like the best")).shouldHave(visible);
    }
}
