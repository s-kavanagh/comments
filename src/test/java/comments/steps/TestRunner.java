package comments.steps;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/comments/feature"
		,glue={"comments.steps"}
		)
 
public class TestRunner {
 
}
