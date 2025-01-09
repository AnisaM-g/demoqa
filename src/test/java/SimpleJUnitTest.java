import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {
    @Test
    // Устанавливаем стратегию загрузки страницы
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        // Открываем страницу
        open("https://www.google.com/");
        // Проверяем первый элемент, если найден, кликаем
        if ($("#L2AGLb").exists()) {
            $("#L2AGLb").click();
        }
        else if ($("[name=q]").exists()) {
            $("[name=q]").click(); // Действие на случай наличия второго элемента
        }
        else {
            System.out.println("Ни один из элементов не найден!"); // Лог на случай отсутствия элементов
        }
        // Выполняем поиск
        $("[name=q]").setValue("selenide").pressEnter();
        // Проверяем, что результат содержит ссылку
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }
}
