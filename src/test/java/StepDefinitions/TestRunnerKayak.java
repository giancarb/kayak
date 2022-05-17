package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/gianlucacarbone/Dev/IdeaProjects/ubs_exercise/aparna/src/test/resources/Features/kayak.feature"}, glue = {"StepDefinitions"},
        plugin = {"junit:target/cucumber-reports/cucumber.xml"},
        monochrome = true
)


public class TestRunnerKayak {





}




