import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GithubSteps {

    @Step("Открыть главную страницу")
    public GithubSteps openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Найти репозиторий {repo}")
    public GithubSteps searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
        return this;
    }

    @Step("Кликнуть по ссылке репозитория {repo}")
    public GithubSteps clickRepoLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }

    @Step("Открыть таб Issues")
    public GithubSteps openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public GithubSteps shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }
}