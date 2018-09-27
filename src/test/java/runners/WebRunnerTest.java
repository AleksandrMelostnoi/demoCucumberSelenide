package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        glue = "steps",
        features = "src/test/resources/features",
        tags = {"@logintest"}
)

@RunWith(Cucumber.class)
public class WebRunnerTest {
    @BeforeClass
    static public void setupTimeout() {
        Configuration.timeout = 15000;
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }
}
