import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepTest {

    private static final String REPO = "selenide/selenide";
    private static final Integer ISSUE = 2780;

    @Test
    public void testCheckGithubIssueWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GithubSteps githubSteps = new GithubSteps();
        githubSteps.openMainPage()
                .searchForRepository(REPO)
                .clickRepoLink(REPO)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(ISSUE);
    }
}