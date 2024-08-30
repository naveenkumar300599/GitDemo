package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="Selenium.StepDefinition",
			monochrome=true,tags="@submitOrder", plugin={"html:target/cucumber.html"})
	public class TeestNGTestRunner extends AbstractTestNGCucumberTests {
		
	
}