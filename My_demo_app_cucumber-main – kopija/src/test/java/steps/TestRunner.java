package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "steps", tags ="@DoTest or @RegressionTest")
public class TestRunner {
}

//darant mvn clean install ištrinti prie tags @DoTest iki @. Ir tada nevykdys visų testų, o tik pataisys informaciją.
//@DoTest or