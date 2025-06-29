package getlandestate.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)//Cucumber ile junitin entegre bir sekilde feature file daki scenariolarimiiz calistirmayi saglar
@CucumberOptions(//Bu notasyon sayesinde hangi scenariolari calistiracagimizi, hangi raporlari alacağımızı belirtiriz
        plugin = {
                "pretty",//console da scenariolarimiz ile ilgili ayrintili bilgi almamizi saglar
                "html:target/default-cucumber-report.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
        },
        features = "src/test/resources/features",
        glue = {"getlandestate/stepdefs", "getlandestate/hooks"},

        tags = "@API11Tugberk",



        dryRun = false,
        monochrome = false//true iken console daki ciktilari tek renk olarak verir
)
public class Runner {
}
/*
dryRun = true secilirse scenariolari calistirmadan feature file daki eksik
stepdefinitionlari kontrol eder, browser acilmaz
 */


