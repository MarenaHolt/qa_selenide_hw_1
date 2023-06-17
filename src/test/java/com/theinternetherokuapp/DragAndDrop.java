package com.theinternetherokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");

        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        elementA.dragAndDrop(DragAndDropOptions.to(elementB));
        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

       // sleep(5000);
    }
}
