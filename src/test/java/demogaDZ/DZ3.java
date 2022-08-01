package demogaDZ;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $("#userNumber").setValue("555-35-35");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(0);
        $(".react-datepicker__year-select").selectOption(92);
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/demogaDZ/picture/test.png"));




    }
}
