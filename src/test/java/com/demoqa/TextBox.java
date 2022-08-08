package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Vital");
        $("#userEmail").setValue("Vital@mail.ru");
        $("#currentAddress").setValue("Vital2@mail.ru");
        $("#permanentAddress").setValue("Vital3@mail.ru");
        $("#submit").click();
        $("#output #name").shouldHave(text("Vital"));
        $("#output #email").shouldHave(text("Vital@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Vital2@mail.ru"));
        $("#output #permanentAddress").shouldHave(text("Vital3@mail.ru"));

    }
}