import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {

    private final static String REPO = "selenide/selenide";
    private final static Integer ISSUE = 2780;

    @Test
    public void searchIssueLambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Найти репозиторий" + REPO, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").submit();
        });

        step("Кликнуть по ссылке репозитория", () -> {
            $(linkText(REPO)).click();
        });

        step("Открыть таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с номером {issue}", () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
}