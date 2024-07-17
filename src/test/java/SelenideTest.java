import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    private final static Integer ISSUE = 2780;

    @Test
    public void testCheckGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("selenide/selenide");
        $("#query-builder-test").submit();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).shouldBe(Condition.exist);
    }
}
