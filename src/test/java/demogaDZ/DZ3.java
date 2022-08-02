package demogaDZ;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DZ3 {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vital");
        $("#lastName").setValue("Major");
        $("#userEmail").setValue("Vital@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8929555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/picture/test.jpg"));
        $("#currentAddress").setValue("Pervaya 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Vital Major"));
        $(".modal-body").shouldHave(text("Vital@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8929555555"));
        $(".modal-body").shouldHave(text("08 January,2021"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Sport"));
        $(".modal-body").shouldHave(text("test.jpg"));
        $(".modal-body").shouldHave(text("Pervaya 1"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();




    }
}
