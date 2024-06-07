package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features", glue = "stepDefinitions", monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
