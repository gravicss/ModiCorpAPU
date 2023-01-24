package cucumber.Options;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\feature\\billPayment.feature", glue= {"stepDefination"})
public class testRunner {

}
