import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 20000;

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("OJIbKa07/demoqa_tests_36");
        $("#query-builder-test").submit();

        $(linkText("OJIbKa07/demoqa_tests_36")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
