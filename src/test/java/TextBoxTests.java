import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Иванов Иван Иванович"); //стандартное сокращение для id, можно и напрямую [id=userName]
                                                            // для класса .
        $("#userEmail").setValue("ivanov@goole.com");
        $("#currentAddress").setValue("Russia");
        $("#permanentAddress").setValue("Russia Federation");

        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Иванов Иван Иванович")); // можно использовать другой синтаксис $("#output #name")
        $("#output #email").shouldHave(text("ivanov@goole.com"));
        $("#output").$("#currentAddress").shouldHave(text("Russia"));
        $("#output").$("#permanentAddress").shouldHave(text("Russia Federation"));
    }
}

