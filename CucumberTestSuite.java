package femadex.portal.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "json:target/serenity-reports/cucumber_report.json"
        },
        tags = "@test-seq-2"
 )
public class CucumberTestSuite {

}
