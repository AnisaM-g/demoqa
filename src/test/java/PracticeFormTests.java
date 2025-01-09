import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {@BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
}

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");

        $("#userEmail").setValue("ivanov@goole.com");

        $("[for='gender-radio-1']").click();

        $("#userNumber").setValue("8919458178");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1985");
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $("div.react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").shouldBe(visible).setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();

        $("[for = 'hobbies-checkbox-2']").click();

        $("#uploadPicture").uploadFromClasspath("img/example.png");

        $("#currentAddress").setValue("Russia, Moscow 1");

        $("#state").click();
        $(".css-26l3qy-menu").$(byText("NCR")).click();
        $("#city").click();
        $(".css-26l3qy-menu").$(byText("Delhi")).click();


        $("#submit").click();

        // Ожидаем, что окно с таблицей данных откроется
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldBe(visible);

        // Проверяем содержимое таблицы
        $(".table-responsive").shouldHave(
                text("Иван Иванов"),
                text("ivanov@goole.com"),
                text("Male"),
                text("8919458178"),
                text("03 March,1985"),
                text("Maths, Biology"),
                text("Reading"),
                text("example.png"),
                text("Russia, Moscow 1"),
                text("NCR Delhi")
        );

        // Закрываем окно
        $("#closeLargeModal").click();
    }
}

